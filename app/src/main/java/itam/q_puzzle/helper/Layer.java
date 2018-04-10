package itam.q_puzzle.helper;

import java.io.Serializable;

/**
 * Created by Muslim muslim on 4/10/2018.
 */

    public class Layer implements Serializable
    {
        private   double  Net;
        public    double  Input[];
        // Vector of inputs signals from previous
        // layer to the current layer
        public Node node[];
        // Vector of nodes in current layer
        // The FeedForward function is called so that
        // the outputs for all the nodes in the current
        // layer are calculated
        public void FeedForward() {
            for (int i = 0; i < node.length; i++) {
                Net = node[i].Threshold;

                for (int j = 0; j < node[i].Weight.length; j++)
                {Net = Net + Input[j] * node[i].Weight[j];
                    System.out.println("Net = "+Double.toString(Net)+"\n");
                }

                node[i].Output = Sigmoid(Net);
                System.out.println("node["+Integer.toString(i)+".Output = "+Double.toString(node[i].Output)+"\n");
            }
        }

        // The Sigmoid function calculates the
// activation/output from the current node
        private double Sigmoid (double Net) {
            return 1/(1+Math.exp(-Net));
        }

        // Return the output from all node in the layer
// in a vector form
        public double[] OutputVector() {

            double Vector[];

            Vector = new double[node.length];

            for (int i = 0; i < node.length; i++)
                Vector[i] = node[i].Output;

            return (Vector);
        }
        public Layer(int NumberOfNodes, int NumberOfInputs) {
            node = new Node[NumberOfNodes];

            for (int i = 0; i < NumberOfNodes; i++)
                node[i] = new Node(NumberOfInputs);

            Input = new double[NumberOfInputs];
        }

        // added by DSK
        public Node[] get_nodes() { return node; }
    }
