import org.jgrapht.ListenableGraph;
import org.jgrapht.event.GraphListener;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultListenableGraph;
import org.jgrapht.graph.SimpleGraph;

import iml.MyGraphListener;

public class ListernGraphModification {

  public static void main(String[] args)
  {
    //测试GraphListener
    ListenableGraph<Object, DefaultEdge> g =
        new DefaultListenableGraph<>(new SimpleGraph<>(DefaultEdge.class));
    GraphListener<Object, DefaultEdge> listener = new MyGraphListener<>();
    g.addGraphListener(listener);

    g.addVertex("nanjing");
  }

}
