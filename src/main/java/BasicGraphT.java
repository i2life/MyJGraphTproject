import bean.Relation;
import bean.Teacher;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import org.jgrapht.Graph;
import org.jgrapht.ListenableGraph;
import org.jgrapht.event.GraphListener;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultListenableGraph;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.traverse.BreadthFirstIterator;
import org.jgrapht.traverse.DepthFirstIterator;
import iml.MyGraphListener;
import org.jgrapht.io.*;

public class BasicGraphT {

  public static void main(String[] args) {

    //测试图的基本操作
    Graph <Teacher, Relation> teacherGraph = createTeacherGraph();

    //深度优先遍历
    DepthFirstIterator iter = new DepthFirstIterator<>(teacherGraph);

    while (iter.hasNext()) {
      Teacher x = (Teacher)iter.next();

      System.out.println(x.toString());
    }

    System.out.println(teacherGraph.toString());

  }

  private static Graph createTeacherGraph() {
    Graph <Teacher, Relation> graph = new SimpleGraph <>(Relation.class);
    Teacher wang = new Teacher("wang", "huawei", 28);
    Teacher li = new Teacher("li", "huawei", 30);
    Teacher chen = new Teacher("chen", "huawei", 35);

    Relation r1 = new Relation("friend", 3);
    Relation r2 = new Relation("friend", 2);
    Relation r3 = new Relation("couple", 10);

    graph.addVertex(wang);
    graph.addVertex(li);
    graph.addVertex(chen);

    graph.addEdge(wang, li, r1);
    graph.addEdge(li, chen, r2);
    graph.addEdge(chen, wang, r3);

    return graph;
  }

}
