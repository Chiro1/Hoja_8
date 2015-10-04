import java.util.PriorityQueue;

import java.util.Vector;

/**
 * @author Christopher Chiroy, 14411; Diego Sosa, sos14735 
 * @param <E>
 */
public class VectorHeap<E extends Comparable<E>>{
	protected Vector<E> data;
	
	/**
	 * post: constructor de nueva cola de prioridad
	 */
	public VectorHeap(){
		data = new Vector<E>();
	}
	
	/**
	 * @param v
	 * post: Constructor de una nueva cola de prioridad para un vector desordenado
	 */
	public VectorHeap(Vector<E> v){
		int i;
		data = new Vector<E>(v.size());
		for (i=0; i<v.size(); i++){
			add(v.get(i));
		}
	}
	
	/**
	 * @param i
	 * @return padre
	 * pre: posicion del hijo
	 * post: posicion en la que se encuentra el padre 
	 */
	protected static int parent(int i){
		return (i-1)/2;
	}
	
	/**
	 * @param i
	 * @return hijo
	 * pre: posicion del padre
	 * post: posicion del hijo izquierdo
	 */
	protected static int left(int i){
		return 2*i+1;
	}
	
	/**
	 * @param i
	 * @return hijo
	 * pre: posicion del padre
	 * post: posicion del hijo derecho
	 */
	protected static int right(int i){
		return 2*(i+1);
	}
	
	
	/**
	 * @param leaf
	 * pre: hoja entre 0 y el tamano del arbol
	 * post: mueve el nodo a una posicion apropiada
	 */
	protected void percolateUp(int leaf){
		int parent = parent(leaf);
		E value = data.get(leaf);
		while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)){
			data.set(leaf,data.get(parent));
			leaf = parent;
			parent = parent(leaf);
		}
		data.set(leaf, value);
	}
	
	/**
	 * @param value
	 * pre: value no sea null
	 * post: value es agregado a la cola de prioridad
	 */
	public void add(E value){
		data.add(value);
		percolateUp(data.size()-1);
	}
	
	/**
	 * @param root
	 * pre: root entre 0 y el tamano de la cola
	 * post: mueve el nodo a una posicion abajo de root
	 */
	protected void pushDownRoot(int root){
		int heapSize = data.size();
		E value = data.get(root);
		while (root<heapSize){
			int childpos = left(root);
			if(childpos < heapSize){
				if ((right(root) < heapSize) && ((data.get(childpos+1)).compareTo(data.get(childpos))<0)){
					childpos++;
				}
				if((data.get(childpos)).compareTo(value)<0){
					data.set(root, data.get(childpos));
					root = childpos;
				}
				else{
					data.set(root, value);
					return;
				}
			}
			else{
				data.set(root, value);
			}
		}
	}
	
	/**
	 * @return raiz
	 * pre: cola iniciada
	 * post: retorna y devuelve el valor minimo de la cola
	 */
	public E remove(){
		E minVal = getFirst();
		data.set(0, data.get(data.size()-1));
		data.setSize(data.size()-1);
		if(data.size() > 1) 
			pushDownRoot(0);
		return minVal;
	}
	
	/**
	 * @return primer valor de la cola
	 */
	public E getFirst(){
		return data.get(0);
	}
}
