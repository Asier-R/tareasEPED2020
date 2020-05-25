package es.uned.lsi.eped.DataStructures;

public class LTree extends GTree<Integer> {

	public ListIF<LTree> getChildrenByName(int value) {
		List<LTree> result = new List<LTree>();
		IteratorIF<GTreeIF<Integer>> it = this.getChildren().iterator();
		while ( it.hasNext() ) {
			LTree next = (LTree) it.getNext();
			if ( next.getRoot() > value ) {
				result.insert(result.size()+1, next);
			}
		}
		return result;
	}

}
