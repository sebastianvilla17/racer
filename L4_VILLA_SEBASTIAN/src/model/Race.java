package model;

import java.util.ArrayList;

public class Race {

	private ArrayList<NumberAL> numberList = new ArrayList<NumberAL>();
	private NumberLL firstN;
	private NumberABB root;

	public Race() {

	}

	//////////////////// ArrayList///////////////

	public void addArrayList(long number) {

		NumberAL tmp = new NumberAL(number);
		numberList.add(tmp);

	}

	///// iteratives///////////

	// Delete
	public boolean deleteArrayListI(long value) {
		boolean deleted = false;
		for (int i = 0; i < numberList.size() && !deleted; i++) {
			if (numberList.get(i).getNumber() == value) {
				numberList.remove(i);
				deleted = true;
			}
		}
		return deleted;
	}

	// Search
	public boolean searchArrayListI(long value) {

		boolean found = false;
		for (int i = 0; i < numberList.size() && !found; i++) {
			if (numberList.get(i).getNumber() == value) {
				found = true;
			}
		}
		return found;
	}

//////////////recursive///////////////////////

	// Search
	public boolean searchArrayListR(long value) {
		return searchArrayListR(0, value);
	}

	private boolean searchArrayListR(int index, long value) {
		//System.out.println(index + " " + value);
		if (index >= numberList.size()) {
			return false;
		} else if (numberList.get(index).getNumber() == value) {
			return true;
		}
		index += 1;
		return searchArrayListR(index, value);
	}

	// Delete
	public boolean deleteArrayListR(long value) {
		return deleteArrayListR(0, value);
	}

	private boolean deleteArrayListR(int index, long value) {
		if (index >= numberList.size()) {
			return false;
		} else if (numberList.get(index).getNumber() == value) {
			numberList.remove(index);
			return true;
		}
		index+=1;
		return deleteArrayListR(index, value);
	}

	///////////// linkedList/////////////////////////

	/// Iterative///////////

	// add
	public void addLinkedListI(long value) {
		NumberLL add = new NumberLL(value);
		if (firstN == null) {
			firstN = add;
		} else {
			NumberLL current = firstN;
			while (current.getNextNumber() != null) {
				current = current.getNextNumber();
			}
			current.setNextNumber(add);
		}
	}

	// delete
	public boolean deleteLinkedListI(long value) {
		boolean deleted = false;
		NumberLL previous = null;
		NumberLL current = firstN;

		while (current != null && !deleted) {

			if (current.getNumber() == value) {
				previous.setNextNumber(current.getNextNumber());
				current = null;
				deleted = true;
			} else if (previous != null) {
				previous = previous.getNextNumber();
				current = current.getNextNumber();
			} else {
				return false;
			}
		}
		return deleted;
	}

	// search
	public boolean searchLinkedListI(long value) {
		boolean exist = false;
		NumberLL current = firstN;
		while (current != null && !exist) {
			if (current.getNumber() == value)
				exist = true;
			current = current.getNextNumber();
		}
		return exist;
	}

	/// Recursive/////////////

	// add
	public void addLinkedListR(long value) {
		firstN = addLinkedListR(firstN, value);
	}

	private NumberLL addLinkedListR(NumberLL current, long value) {
		if (current == null) {
			return new NumberLL(value);
		} else if (current.getNextNumber()==null) {
			current.setNextNumber(addLinkedListR(current.getNextNumber(), value));
		}
		return current;
	}

	// delete
	public void deleteLinkedListR(long value) {
		firstN = deleteLinkeListR(firstN, value);
	}

	private NumberLL deleteLinkeListR(NumberLL current, long value) {
		if (current == null)
			return null;
		if (current.getNumber() == value) {
			NumberLL tmpNext;
			tmpNext = current.getNextNumber();
			current = null;
			return tmpNext;
		}
		current.setNextNumber(deleteLinkeListR(current.getNextNumber(), value));
		return current;
	}

	// search
	public boolean SearchLinkedListR(long value) {
		return SearchLinkedListR(firstN, value);
	}

	private boolean SearchLinkedListR(NumberLL current, long value) {
		if (current == null) {
			return false;
		} else if (current.getNumber() == value) {
			return true;
		}
		return SearchLinkedListR(current.getNextNumber(), value);
	}

	/////////////////// ABB//////////////////

	///// Recursive//////

	private long findMinimum(NumberABB root) {
		return root.getLeft() == null ? root.getValue() : findMinimum(root.getLeft());
	}

	// add
	public void addABBR(long value) {
		root = addABBR(root, value);
	}

	private NumberABB addABBR(NumberABB current, long value) {
		if (current == null)
			return new NumberABB(value);
		if (value < current.getValue()) {
			current.setLeft(addABBR(current.getLeft(), value));
		} else if (value > current.getValue()) {
			current.setRight(addABBR(current.getRight(), value));
		} else {
			return current;
		}
		return current;
	}

	// delete
	public void deleteABBR(long value) {
		root = deleteABBR(root, value);
	}

	private NumberABB deleteABBR(NumberABB current, long value) {
		if (current == null)
			return null;
		if (current.getValue() == value) {
			if (current.getLeft() == null && current.getRight() == null)
				return null;
			if (current.getRight() == null)
				return current.getLeft();
			if (current.getLeft() == null)
				return current.getRight();
			long less = findMinimum(current.getRight());
			current.setValue(less);
			current.setRight(deleteABBR(current.getRight(), less));
			return current;
		}
		if (current.getValue() > value) {
			current.setLeft(deleteABBR(current.getLeft(), value));
			return current;
		} else {
			current.setRight(deleteABBR(current.getRight(), value));
			return current;
		}
	}

	// search

	public boolean searchABBR(long value) {
		return searchABBR(root, value);
	}

	private boolean searchABBR(NumberABB current, long value) {
		if (current == null)
			return false;
		if (current.getValue() == value)
			return true;
		return current.getValue() > value ? searchABBR(current.getLeft(), value)
				: searchABBR(current.getRight(), value);
	}

	////// Iterative/////////////

	// add
	public void addABBI(long value) {
		NumberABB add = new NumberABB(value);
		NumberABB current = root;
		boolean exist = false;
		while (current != null && !exist) {
			if (current.getValue() > value) {
				current = current.getLeft();
			} else if (current.getValue() < value) {
				current = current.getRight();
			} else {
				exist = true;
			}
		}
		if (exist == false)
			current = add;
	}

	// search
	public boolean searchABBI(long value) {
		NumberABB current = root;
		while (current != null) {
			if (current.getValue() > value) {
				current = current.getLeft();
			} else if (current.getValue() < value) {
				current = current.getRight();
			} else {
				return true;
			}
		}
		return false;
	}

	// delete
	public boolean deleteABBI(long number) {

		boolean deleted = false;

		if (root != null) {
			NumberABB current = root;

			boolean flag = true;

			while (current != null && flag) {
				if (current.getValue() == number) {

					if (current.getLeft() == null && current.getRight() == null) {
						case1(current);

					} else if (current.getLeft() == null || current.getRight() == null) {
						case2(current);

					} else {
						case3(current);

					}

					deleted = true;
					flag = false;
				}
				if (current.getValue() < number) {
					current = current.getRight();
				} else {
					current = current.getLeft();
				}
			}
		}
		return deleted;
	}

	private boolean case1(NumberABB nodo) {

		NumberABB leftSon = nodo.getParent().getLeft();
		NumberABB rightSon = nodo.getParent().getRight();

		if (leftSon == nodo) {
			nodo.getParent().setLeft(null);
			return true;
		}

		if (rightSon == nodo) {
			nodo.getParent().setRight(null);
			return true;
		}

		return false;
	}

	private boolean case2(NumberABB nodo) {

		NumberABB leftSon = nodo.getParent().getLeft();
		NumberABB rightSon = nodo.getParent().getRight();

		NumberABB currentSon = nodo.getLeft() != null ? nodo.getLeft() : nodo.getRight();

		if (leftSon == nodo) {
			nodo.getParent().setLeft(currentSon);
			currentSon.setParent(nodo.getParent());
			nodo.setRight(null);
			nodo.setLeft(null);

			return true;
		}

		if (rightSon == nodo) {
			nodo.getParent().setRight(currentSon);

			currentSon.setParent(nodo.getParent());
			nodo.setRight(null);
			nodo.setLeft(null);

			return true;
		}

		return false;
	}

	private boolean case3(NumberABB nodo) {

		NumberABB nodeToTheLeft = TourToTheLeft(nodo.getRight());
		if (nodeToTheLeft != null) {

			nodo.setValue(nodeToTheLeft.getValue());

			deleteABBI(nodeToTheLeft.getValue());
			return true;
		}
		return false;
	}

	private NumberABB TourToTheLeft(NumberABB nodo) {
		if (nodo.getLeft() != null) {
			return TourToTheLeft(nodo.getLeft());
		}
		return nodo;
	}
}
