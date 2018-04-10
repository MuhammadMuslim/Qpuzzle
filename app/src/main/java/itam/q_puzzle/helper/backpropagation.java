package itam.q_puzzle.helper;

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Muslim muslim on 4/10/2018.
 */

public class backpropagation extends  Thread  implements Serializable
{
    private double   OverallError;
    // The minimum Error Function defined by the user
    private double   MinimumError;
    // The user-defined expected output pattern for a set of samples
    private double   ExpectedOutput[][];
    // The user-defined input pattern for a set of samples
    private double   Input[][];
    // User defined learning rate - used for updating the network weights
    private double   LearningRate;
    // Users defined momentum - used for updating the network weights
    private double   Momentum;
    // Number of layers in the network
    private  int NumberOfLayers;
    // Number of training sets
    private  int NumberOfSamples;
    // Current training set/sample that is used to train network
    private  int SampleNumber;
    // Maximum number of Epochs before the traing stops training
    private long MaximumNumberOfIterations;
    // Public Variables
    public Layer layer[];
    public  double   ActualOutput[][];
    long delay = 0;
    boolean die = false;
    // Calculate the node activations
    public void FeedForward()
    {
        int i,j;
        // Since no weights contribute to the output
        // vector from the input layer,
        // assign the input vector from the input layer
        // to all the node in the first hidden layer
        for (i = 0; i < layer[0].node.length; i++)
            layer[0].node[i].Output = layer[0].Input[i];
        layer[1].Input = layer[0].Input;
        for (i = 1; i < NumberOfLayers; i++)
        {
            layer[i].FeedForward();
            // Unless we have reached the last layer, assign the layer i's    //output vector
            // to the (i+1) layer's input vector
            if (i != NumberOfLayers-1)
                layer[i+1].Input = layer[i].OutputVector();
        }
    }
    // FeedForward()
    // Back propagated the network outputy error through
    // the network to update the weight values
    public void UpdateWeights()
    {
        CalculateSignalErrors();
        BackPropagateError();
    }
    private void CalculateSignalErrors()
    {
        int i,j,k,OutputLayer;
        double Sum;
        OutputLayer = NumberOfLayers-1;
        // Calculate all output signal error
        for (i = 0; i < layer[OutputLayer].node.length; i++)
        {
            layer[OutputLayer].node[i].SignalError =
                    (ExpectedOutput[SampleNumber][i] - layer[OutputLayer].node[i].Output) *
                            layer[OutputLayer].node[i].Output *
                            (1- layer[OutputLayer].node[i].Output);
        }
        // Calculate signal error for all nodes in the hidden layer
        // (back propagate the errors
        for (i = NumberOfLayers-2; i > 0; i--)
        {
            for (j = 0; j < layer[i].node.length; j++)
            {
                Sum = 0;
                for (k = 0; k < layer[i+1].node.length; k++)
                    Sum = Sum + layer[i+1].node[k].Weight[j] *
                            layer[i+1].node[k].SignalError;
                layer[i].node[j].SignalError = layer[i].node[j].Output*(1 -
                        layer[i].node[j].Output)*Sum;
            }
        }
    }

    private void BackPropagateError()
    {
        int i,j,k;
        // Update Weights
        for (i = NumberOfLayers-1; i > 0; i--)
        {
            for (j = 0; j < layer[i].node.length; j++)
            {
                // Calculate Bias weight difference to node j
                layer[i].node[j].ThresholdDiff = LearningRate *
                        layer[i].node[j].SignalError +
                        Momentum* layer[i].node[j].ThresholdDiff;
                // Update Bias weight to node j
                layer[i].node[j].Threshold =
                        layer[i].node[j].Threshold +
                                layer[i].node[j].ThresholdDiff;
                // Update Weights
                for (k = 0; k < layer[i].Input.length; k++)
                {
                    // Calculate weight difference between node j and k
                    layer[i].node[j].WeightDiff[k] =
                            LearningRate *
                                    layer[i].node[j].SignalError* layer[i-
                                    1].node[k].Output +
                                    Momentum* layer[i].node[j].WeightDiff[k];
                    // Update weight between node j and k
                    layer[i].node[j].Weight[k] =
                            layer[i].node[j].Weight[k] +
                                    layer[i].node[j].WeightDiff[k];
                }
            }
        }
    }
    private void CalculateOverallError()
    {
        int i,j;
        OverallError = 0;
        for (i = 0; i < NumberOfSamples; i++)
            for (j = 0; j < layer[NumberOfLayers-1].node.length; j++)
            {
                OverallError = OverallError +
                        0.5*( Math.pow(ExpectedOutput[i][j] - ActualOutput[i]
                                [j],2) );
            }
    }
    public backpropagation(int NumberOfNodes[],
                            double InputSamples[][],
                            double OutputSamples[][],
                            double LearnRate,
                            double Moment,
                            double MinError,
                            long MaxIter
    )
    {
        int i,j;
        // Initiate variables
        NumberOfSamples = InputSamples.length;
        MinimumError = MinError;
        LearningRate = LearnRate;
        Momentum = Moment;
        NumberOfLayers = NumberOfNodes.length;
        MaximumNumberOfIterations = MaxIter;
        // Create network layers
        layer = new Layer[NumberOfLayers];
        // Assign the number of node to the input layer
        layer[0] = new Layer(NumberOfNodes[0],NumberOfNodes[0]);
        // Assign number of nodes to each layer
        for (i = 1; i < NumberOfLayers; i++)
            layer[i] = new Layer(NumberOfNodes[i],NumberOfNodes[i-1]);
        Input = new double[NumberOfSamples][layer[0].node.length];
        ExpectedOutput = new double[NumberOfSamples][layer[NumberOfLayers-
                1].node.length];
        ActualOutput = new double[NumberOfSamples][layer[NumberOfLayers-
                1].node.length];
        // Assign input set
        for (i = 0; i < NumberOfSamples; i++)
            for (j = 0; j < layer[0].node.length; j++)
                Input[i][j] = InputSamples[i][j];
        // Assign output set
        for (i = 0; i < NumberOfSamples; i++)
            for (j = 0; j < layer[NumberOfLayers-1].node.length; j++)
                ExpectedOutput[i][j] = OutputSamples[i][j];
    }
    public void TrainNetwork()
    {
        int i,j;
        long k=0;
        do
        {
            // For each pattern
            for (SampleNumber = 0; SampleNumber < NumberOfSamples; SampleNumber++)
            {
                for (i = 0; i < layer[0].node.length; i++)
                    layer[0].Input[i] = Input[SampleNumber][i];
                FeedForward();
                // Assign calculated output vector from network to ActualOutput
                for (i = 0; i < layer[NumberOfLayers-1].node.length; i++)
                    ActualOutput[SampleNumber][i] = layer[NumberOfLayers-
                            1].node[i].Output;
                UpdateWeights();
                // if we've been told to stop training, then
                // stop thread execution
                if (die){
                    return;
                }
                // if
            }
            k++;
            // Calculate Error Function
            CalculateOverallError();
            System.out.println("OverallError ="+Double.toString(OverallError)+"\n");
                    System.out.print("Epoch = "+Long.toString(k)+"\n");
        } while ((OverallError > MinimumError) &&(k < MaximumNumberOfIterations));
    }
    public Layer[] get_layers() { return layer; }
    // called when testing the network.
    public double[] test(double[] input)
    {
        int winner = 0;
        Node[] output_nodes;
        for (int j = 0; j < layer[0].node.length; j++)
        { layer[0].Input[j] = input[j];}
        FeedForward();
        // get the last layer of nodes (the outputs)
        output_nodes = (layer[layer.length - 1]).get_nodes();
        double[] actual_output  = new double[output_nodes.length];
        for (int k=0; k < output_nodes.length; k++)
        {
            actual_output[k]=output_nodes[k].Output;
        } // for
        return actual_output;
    }//test()
    public double get_error()
    {
        CalculateOverallError();
        return OverallError;
    } // get_error()
    // to change the delay in the network
    public void set_delay(long time)
    {
        if (time >= 0) {
            delay = time;
        } // if
    }
    //save the trained network
    public void save(String FileName)
    {
        try{


            FileOutputStream fos = new FileOutputStream(new File(FileName), true);
            // Serialize data object to a file
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(this);
            os.close();
            fos.close();
            System.out.println("Network Saved!!!!");
        }
        catch (IOException E){System.out.println(E.toString());}
        catch (Exception e){System.out.println(e.toString());}
    }


    public  backpropagation load(String FileName)
    {

        backpropagation myclass= null;
        try
        {

            //File patternDirectory = new File(Environment.getExternalStorageDirectory().getAbsolutePath().toString()+"INDIAN_NUMBER_RECOGNITION.data");
            //patternDirectory.mkdirs();
            FileInputStream fis = new FileInputStream(new File(FileName));
            //FileInputStream fis =context.openFileInput(FileName);
            ObjectInputStream is = new ObjectInputStream(fis);
            myclass = (backpropagation) is.readObject();
            System.out.println("Error After Reading = "+Double.toString(myclass.get_error())+"\n");
            is.close();
            fis.close();
            return myclass;


        }
        catch (Exception e){System.out.println(e.toString());}
        return myclass;
    }

    // needed to implement threading.
    public void run() {
        TrainNetwork();
        File Net_File = new File(Environment.getExternalStorageDirectory(),"Number_Recognition_1.ser");
        save(Net_File.getAbsolutePath());
        System.out.println( "DONE TRAINING :) ^_^ ^_^ :) !\n");
        System.out.println("With Network ERROR = "+Double.toString(get_error())+"\n");
    } // run()


    // to notify the network to stop training.
    public void kill() { die = true; }
}