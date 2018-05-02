package itam.q_puzzle.method_engine;

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

public class Backpropagation extends  Thread  implements Serializable
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
    public Backpropagation(int NumberOfNodes[],
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
            System.out.println("Saved!!!!");
        }
        catch (IOException E){System.out.println(E.toString());}
        catch (Exception e){System.out.println(e.toString());}
    }

    public Backpropagation() {

    }

    public Backpropagation load(String FileName)
    {

        Backpropagation myclass= null;
        try
        {

            //File patternDirectory = new File(Environment.getExternalStorageDirectory().getAbsolutePath().toString()+"INDIAN_NUMBER_RECOGNITION.data");
            //patternDirectory.mkdirs();
            FileInputStream fis = new FileInputStream(new File(FileName));
            //FileInputStream fis =context.openFileInput(FileName);
            ObjectInputStream is = new ObjectInputStream(fis);
            myclass = (Backpropagation) is.readObject();
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
        System.out.println( "DONE TRAINING\n");
        System.out.println("With ERROR = "+Double.toString(get_error())+"\n");
    } // run()

    // to notify the network to stop training.
    public void kill() { die = true; }

    public class Leveling {

        double waktu;
        double kesalahan;
        double bantuan;
        double r1, r2, r3, r4, r5, r6, r7, r8, r9, r10;
        double r11, r12, r13, r14, r15, r16, r17, r18, r19, r20;
        double r21, r22, r23, r24, r25, r26, r27;
        int z1, z2, z3, z4, z5, z6, z7, z8, z9, z10;
        int z11, z12, z13, z14, z15, z16, z17, z18, z19, z20;
        int z21, z22, z23, z24, z25, z26, z27;
        double rizi, ri;
        double z;
        int level;
        double a;
        double waktuCepat;
        double waktuNormal;
        double waktuLambat;
        double b;
        double kesalahanRendah;
        double kesalahanSedang;
        double kesalahanTinggi;
        double c;
        double bantuanRendah;
        double bantuanSedang;
        double bantuanTinggi;

        public double getZ() {
            return  this.z;
        }

        public int getLevel(double waktu, double kesalahan, double bantuan) {
            this.waktu = waktu;
            this.kesalahan = kesalahan;
            this.bantuan = bantuan;

            waktuCepat = getWaktuCepat(this.waktu);
            waktuNormal = getWaktuNormal(this.waktu);
            waktuLambat = getWaktuLambat(this.waktu);

            kesalahanRendah = getKesalahanRendah(this.kesalahan);
            kesalahanSedang = getKesalahanSedang(this.kesalahan);
            kesalahanTinggi = getKesalahanTinggi(this.kesalahan);

            bantuanRendah = getBantuanRendah(this.bantuan);
            bantuanSedang = getBantuanSedang(this.bantuan);
            bantuanTinggi = getBantuanTinggi(this.bantuan);

            r1 = Math.min(waktuCepat, Math.min(kesalahanRendah, bantuanRendah));
            z1 = 3;

            r2 = Math.min(waktuCepat, Math.min(kesalahanRendah, bantuanSedang));
            z2 = 2;

            r3 = Math.min(waktuCepat, Math.min(kesalahanRendah, bantuanTinggi));
            z3 = 1;

            r4 = Math.min(waktuCepat, Math.min(kesalahanSedang, bantuanRendah));
            z4 = 2;

            r5 = Math.min(waktuCepat, Math.min(kesalahanSedang, bantuanSedang));
            z5 = 2;

            r6 = Math.min(waktuCepat, Math.min(kesalahanSedang, bantuanTinggi));
            z6 = 1;

            r7 = Math.min(waktuCepat, Math.min(kesalahanTinggi, bantuanRendah));
            z7 = 1;

            r8 = Math.min(waktuCepat, Math.min(kesalahanTinggi, bantuanSedang));
            z8 = 1;

            r9 = Math.min(waktuCepat, Math.min(kesalahanTinggi, bantuanTinggi));
            z9 = 1;

            r10 = Math.min(waktuNormal, Math.min(kesalahanRendah, bantuanRendah));
            z10 = 2;

            r11 = Math.min(waktuNormal, Math.min(kesalahanRendah, bantuanSedang));
            z11 = 2;

            r12 = Math.min(waktuNormal, Math.min(kesalahanRendah, bantuanTinggi));
            z12 = 1;

            r13 = Math.min(waktuNormal, Math.min(kesalahanSedang, bantuanRendah));
            z13 = 2;

            r14 = Math.min(waktuNormal, Math.min(kesalahanSedang, bantuanSedang));
            z14 = 2;

            r15 = Math.min(waktuNormal, Math.min(kesalahanSedang, bantuanTinggi));
            z15 = 1;

            r16 = Math.min(waktuNormal, Math.min(kesalahanTinggi, bantuanRendah));
            z16 = 1;

            r17 = Math.min(waktuNormal, Math.min(kesalahanTinggi, bantuanSedang));
            z17 = 1;

            r18 = Math.min(waktuNormal, Math.min(kesalahanTinggi, bantuanTinggi));
            z18 = 1;

            r19 = Math.min(waktuLambat, Math.min(kesalahanRendah, bantuanRendah));
            z19 = 1;

            r20 = Math.min(waktuLambat, Math.min(kesalahanRendah, bantuanSedang));
            z20 = 1;

            r21 = Math.min(waktuLambat, Math.min(kesalahanRendah, bantuanTinggi));
            z21 = 1;

            r22 = Math.min(waktuLambat, Math.min(kesalahanSedang, bantuanRendah));
            z22 = 1;

            r23 = Math.min(waktuLambat, Math.min(kesalahanSedang, bantuanSedang));
            z23 = 1;

            r24 = Math.min(waktuLambat, Math.min(kesalahanSedang, bantuanTinggi));
            z24 = 1;

            r25 = Math.min(waktuLambat, Math.min(kesalahanTinggi, bantuanRendah));
            z25 = 1;

            r26 = Math.min(waktuLambat, Math.min(kesalahanTinggi, bantuanSedang));
            z26 = 1;

            r27 = Math.min(waktuLambat, Math.min(kesalahanTinggi, bantuanTinggi));
            z27 = 1;

            rizi = (r1*z1)+(r2*z2)+(r3*z3)+(r4*z4)+(r5*z5)+(r6*z6)+(r7*z7)+(r8*z8)+(r9*z9)+(r10*z10)+
                    (r11*z11)+(r12*z12)+(r13*z13)+(r14*z14)+(r15*z15)+(r16*z16)+(r17*z17)+(r18*z18)+(r19*z19)+(r20*z20)+
                    (r21*z21)+(r22*z22)+(r23*z23)+(r24*z24)+(r25*z25)+(r26*z26)+(r27*z27);
            ri = r1+r2+r3+r4+r5+r6+r7+r8+r9+r10+r11+r12+r13+r14+r15+r16+r17+r18+r19+r20+r21+r22+r23+r24+r25+r26+r27;

            z = rizi/ri;

            this.level = (int) Math.round(z);

            return this.level;
        }

        public double getWaktuCepat(double waktu) {

            a = waktu;

            if(a<=1.5) {

                waktuCepat = 1;
            }
            else if(a>1.5 && a<4.5) {

                waktuCepat = (4.5-a)/(4.5-1.5);
            }
            else if(a>=4.5) {

                waktuCepat = 0;
            }

            return waktuCepat;
        }

        public double getWaktuNormal(double waktu) {

            a = waktu;

            if(a<=3 || a>=6) {

                waktuNormal = 0;
            }
            else if(a>3 && a<=4.5) {

                waktuNormal = (a-3)/(4.5-3);
            }
            else if(a>4.5 && a<6) {

                waktuNormal = (6-a)/(6-4.5);
            }

            return waktuNormal;
        }

        public double getWaktuLambat(double waktu) {

            a = waktu;

            if(a<=4.5) {

                waktuLambat = 0;
            }
            else if(a>4.5 && a<7.5) {

                waktuLambat = (a-4.5)/(7.5-4.5);
            }
            else if(a>=7.5) {

                waktuLambat = 1;
            }

            return waktuLambat;
        }

        public double getKesalahanRendah(double kesalahan) {

            b = kesalahan;

            if(b>=0 && b<0.2) {

                kesalahanRendah = (0.2-b)/(0.2-0);
            }
            else if(b>=0.2) {

                kesalahanRendah = 0;
            }

            return kesalahanRendah;
        }

        public double getKesalahanSedang(double kesalahan) {

            b = kesalahan;

            if(b<=0.1 || b>=0.3) {

                kesalahanSedang = 0;
            }
            else if(b>0.1 && b<=0.2) {

                kesalahanSedang = (b-0.1)/(0.2-0.1);
            }
            else if(b>0.2 && b<0.3) {

                kesalahanSedang = (0.3-b)/(0.3-0.2);
            }

            return kesalahanSedang;
        }

        public double getKesalahanTinggi(double kesalahan) {

            b = kesalahan;

            if(b<=0.2) {

                kesalahanTinggi = 0;
            }
            else if(b>0.2 && b<0.4) {

                kesalahanTinggi = (b-0.2)/(0.4-0.2);
            }
            else if(b>=0.4) {

                kesalahanTinggi = 1;
            }

            return kesalahanTinggi;
        }

        public double getBantuanRendah(double bantuan) {

            c = bantuan;

            if(c>=0 && c<0.2) {

                bantuanRendah = (0.2-c)/(0.2-0);
            }
            else if(c>=0.2) {

                bantuanRendah = 0;
            }

            return bantuanRendah;
        }

        public double getBantuanSedang(double bantuan) {

            c = bantuan;

            if(c<=0.1 || c>=0.3) {

                bantuanSedang = 0;
            }
            else if(c>0.1 && c<=0.2) {

                bantuanSedang = (c-0.1)/(0.2-0.1);
            }
            else if(c>0.2 && c<0.3) {

                bantuanSedang = (0.3-c)/(0.3-0.2);
            }

            return bantuanSedang;
        }

        public double getBantuanTinggi(double bantuan) {

            c = bantuan;

            if(c<=0.2) {

                bantuanTinggi = 0;
            }
            else if(c>0.2 && c<0.4) {

                bantuanTinggi = (c-0.2)/(0.4-0.2);
            }
            else if(c>=0.4) {

                bantuanTinggi = 1;
            }

            return bantuanTinggi;
        }
    }

}