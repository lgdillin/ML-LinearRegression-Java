import java.util.ArrayList;


public class NeuralNet extends SupervisedLearner {
  protected Vec weights;
  //protected ArrayList<Layer> layers;
  protected ArrayList<LayerLinear> layers;

  NeuralNet() {
    layers = new ArrayList<LayerLinear>();
  }

  String name() {
    return "Linear Regression";
  }

  Vec predict(Vec in) {
    layers.get(0).activate(weights, in);
    System.out.println(weights);
    weights = new Vec(layers.get(0).activation);

    return weights;
  }

  /// Train this supervised learner
  void train(Matrix features, Matrix labels) {
    System.out.println("y: " + labels.rows() + " " + labels.cols());
    layers.clear();
    LayerLinear ll = new LayerLinear(features.cols(), labels.cols());
    layers.add(ll);
    for(int i = 0; i < layers.size(); ++i) {
      layers.get(i).ordinary_least_squares(features, labels, weights);
    }
  }

}
