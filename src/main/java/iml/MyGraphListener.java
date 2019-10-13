package iml;

import org.jgrapht.event.GraphEdgeChangeEvent;
import org.jgrapht.event.GraphListener;
import org.jgrapht.event.GraphVertexChangeEvent;

public class MyGraphListener<E> implements GraphListener<Object, E> {

  @Override
  public void edgeAdded(GraphEdgeChangeEvent <Object, E> graphEdgeChangeEvent) {

  }

  @Override
  public void edgeRemoved(GraphEdgeChangeEvent <Object, E> graphEdgeChangeEvent) {

  }

  @Override
  public void vertexAdded(GraphVertexChangeEvent <Object> graphVertexChangeEvent) {

    System.out.println("vertex add: "+graphVertexChangeEvent.getVertex().toString());

  }

  @Override
  public void vertexRemoved(GraphVertexChangeEvent <Object> graphVertexChangeEvent) {

  }
}
