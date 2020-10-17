
public class StringLL implements Comparable<StringLL> {

	private class Node {
		private String item;
		private Node next;

		private Node(String item) {
			this.item = item;
			this.next = null;
		}

		private Node(String item, Node next) {
			this.item = item;
			this.next = next;
		}

		public String getItem() {
			return item;
		}

		public void setItem(String item) {
			this.item = item;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

	private Node first;

	public StringLL() {
		first = null;
	}

	public StringLL(String message) {
		first = new Node("" + message.charAt(0));
		Node messageNode = first;
		for (int i = 1; i < message.length(); i++) {
			Node newNode = new Node("" + message.charAt(i));
			messageNode.setNext(newNode);
			messageNode = messageNode.getNext();

		}
	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public String toString() {
		if (first == null)
			return "Empty linked list";
		String strRep = "";
		Node curr = first;
		while (curr != null) {
			strRep += curr.item;
			curr = curr.next;
		}
		return strRep;
	}

	public int indexOf(char x) {
		Node curr = first;
		int currNums = 1;

		while (curr != null) {
			if (curr.getItem().charAt(0) == x) {
				return currNums;
			}
			curr = curr.next;
			currNums++;
		}
		return -1;
	}

	public void replace(char S, char D) {
		Node curr = first;

		while (curr != null) {
			if (curr.getItem().charAt(0) == S) {
				curr.setItem("" + D);
			}
			curr = curr.next;
		}
	}

	public int charCount(char C) {
		Node curr = first;
		int nums = 0;
		while (curr != null) {
			if (curr.getItem().charAt(0) == C)
				nums++;
			curr = curr.next;
		}
		return nums;
	}

	public int compareTo(StringLL list2) {
		Node curr = first;
		Node curr2 = list2.getFirst();
		String strRep = "";

		while (curr != null) {
			// strRep += curr.item;
			while (curr2 != null) {
				if (curr.getItem().charAt(0) != curr2.getItem().charAt(0)) {
					
					
					if (curr.getItem().charAt(0) < curr2.getItem().charAt(0)) {
						return -1;
					} else if (curr.getItem().charAt(0) > curr2.getItem().charAt(0)) {
						return 1;
					}
					curr2 = curr2.next;
				}
				curr = curr.next;
			}
		}
		return 0;
	}

	public StringLL substring(int startPosition) {
		StringLL newList = new StringLL();
		int counter = 1;
		Node curr = first;
		Node newListNode = null;
		while (curr != null) {
				if (counter == startPosition) {
					String firstNodeItem = curr.getItem();
					newListNode = new Node(firstNodeItem);
					newList.setFirst(newListNode);
				}
				else if (counter > startPosition) {
				Node newNode = new Node(curr.getItem());
				newListNode.setNext(newNode);
				newListNode = newListNode.getNext();
			}
			curr = curr.next;
			counter++;
		}
		return newList;
	}

	public StringLL substring(int startPosition, int numChars) {
		StringLL newList = new StringLL();
		int counter = 1;
		int counter2 = 0;
		Node curr = first;
		Node newListNode = null;

		while (curr != null) {

			if (counter == startPosition) {
				String firstNodeItem = curr.getItem();
				newListNode = new Node(firstNodeItem);
				newList.setFirst(newListNode);
				counter2++;
			} else if (counter > startPosition && counter2 != numChars) {
				Node newNode = new Node(curr.getItem());
				newListNode.setNext(newNode);
				newListNode = newListNode.getNext();
				counter2++;
			}

			curr = curr.next;
			counter++;
		}
		return newList;
	}
}
