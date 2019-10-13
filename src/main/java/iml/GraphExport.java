package iml;

import java.io.StringWriter;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.rmi.server.ExportException;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.io.ComponentNameProvider;
import org.jgrapht.io.DOTExporter;
import org.jgrapht.io.GraphExporter;

public class GraphExport {

  public static void main(String[] args)
      throws ExportException, org.jgrapht.io.ExportException, URISyntaxException {

    // create a graph based on URI objects
    Graph <URI, DefaultEdge> hrefGraph = createHrefGraph();

    System.out.println("-- renderHrefGraph output");
    renderHrefGraph(hrefGraph);
    System.out.println();
  }

  private static Graph <URI, DefaultEdge> createHrefGraph()
      throws URISyntaxException {

    Graph <URI, DefaultEdge> g = new DefaultDirectedGraph <>(DefaultEdge.class);

    URI google = new URI("http://www.google.com");
    URI wikipedia = new URI("http://www.wikipedia.org");
    URI jgrapht = new URI("http://www.jgrapht.org");

    // add the vertices
    g.addVertex(google);
    g.addVertex(wikipedia);
    g.addVertex(jgrapht);

    // add edges to create linking structure
    g.addEdge(jgrapht, wikipedia);
    g.addEdge(google, jgrapht);
    g.addEdge(google, wikipedia);
    g.addEdge(wikipedia, google);

    return g;
  }


  /**
   * Render a graph in DOT format.
   *
   * @param hrefGraph a graph based on URI objects
   */
  private static void renderHrefGraph(Graph <URI, DefaultEdge> hrefGraph)
      throws ExportException, org.jgrapht.io.ExportException {

    // use helper classes to define how vertices should be rendered,
    // adhering to the DOT language restrictions
    ComponentNameProvider <URI> vertexIdProvider = new ComponentNameProvider <URI>() {
      public String getName(URI uri) {
        return uri.getHost().replace('.', '_');
      }
    };
    ComponentNameProvider <URI> vertexLabelProvider = new ComponentNameProvider <URI>() {
      public String getName(URI uri) {
        return uri.toString();
      }
    };
    GraphExporter <URI, DefaultEdge> exporter =
        new DOTExporter <>(vertexIdProvider, vertexLabelProvider, null);
    Writer writer = new StringWriter();
    exporter.exportGraph(hrefGraph, writer);
    System.out.println(writer.toString());
  }

}
