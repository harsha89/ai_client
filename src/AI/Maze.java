package AI;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Maze {

	private int rows;
	private int columns;
	private Square[][] elements;
	private Square goal;
	private List<Square> opened = new ArrayList<Square>();
	private List<Square> closed = new ArrayList<Square>();
	private List<Square> bestList = new ArrayList<Square>();

	public Maze(int rows, int columns) {

		this.rows = rows;
		this.columns = columns;
	}

	public void init(Square[][] square)
        {
                this.setElements(square);
		generateAdjacenies();
	}

	public int getRows() {

		return rows;
	}

	public int getColumns() {

		return columns;
	}

	private void generateAdjacenies() {

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
                              
				getElements()[i][j].calculateAdjacencies();
			}
		}
	}
	public Square getSquare(int x, int y) {

		return getElements()[x][y];
	}

	public void setSquare(Square square) {

		getElements()[square.getX()][square.getY()] = square;
	}

    /**
     * @return the elements
     */
    public Square[][] getElements() {
        return elements;
    }

    /**
     * @param elements the elements to set
     */
    public void setElements(Square[][] elements) {
        this.elements = elements;
    }
//    public void setEndStart()
//    {
//        this.getSquare(1, 3).setEnd(true);
//        this.getSquare(5, 5).setStart(true);
//        goal = elements[1][3];
//    }
    public void setGoal(int x,int y)
    {
        this.getSquare(x, y).setEnd(true);
        goal=elements[x][y];
    }

	

	
	 public List<Square> findBestPath(int i,int j) {
                this.getSquare(i, j).setStart(true);
		System.out.println("Calculating best path...");
		Set<Square> adjacencies = elements[i][j].getAdjacencies();
		for (Square adjacency : adjacencies) {
			adjacency.setParent(elements[i][j]);
			if (adjacency.isStart() == false) {
				opened.add(adjacency);
			}
		}

		while (opened.size() > 0) {
			Square best = findBestPassThrough();
			opened.remove(best);
			closed.add(best);
			if (best.isEnd()) {
				System.out.println("Found Goal");
				populateBestList(goal);
				return bestList;
			} else {
				Set<Square> neighbors = best.getAdjacencies();
				for (Square neighbor : neighbors) {
					if (opened.contains(neighbor)) {
						Square tmpSquare = new Square(neighbor.getX(),
								neighbor.getY(), this);
						tmpSquare.setParent(best);
						if (tmpSquare.getPassThrough(goal) >= neighbor
								.getPassThrough(goal)) {
							continue;
						}
					}

					if (closed.contains(neighbor)) {
						Square tmpSquare = new Square(neighbor.getX(),
								neighbor.getY(), this);
						tmpSquare.setParent(best);
						if (tmpSquare.getPassThrough(goal) >= neighbor
								.getPassThrough(goal)) {
							continue;
						}
					}


					neighbor.setParent(best);

					opened.remove(neighbor);
					closed.remove(neighbor);
					opened.add(0, neighbor);
				}
			}
		}
                System.out.println("No path found......");
		return null;
	}

	private void populateBestList(Square square) {

		bestList.add(square);
		if (square.getParent().isStart() == false) {
			populateBestList(square.getParent());
		}

		return;
	}

	private Square findBestPassThrough() {

		Square best = null;
		for (Square square : opened) {
			if (best == null	|| square.getPassThrough(goal) < best.getPassThrough(goal)) {
				best = square;
			}
		}

		return best;
	}
        public void printBestList()
    {
            for(int i=0;i<bestList.size();i++)
            {
                System.out.println(bestList.get(i).getX()+"awwwwwwww"+bestList.get(i).getY());
            }
        }
public void clear()
    {
    for(int i=0;i<rows;i++)
    {
        for(int j=0;i<columns;j++)
        {
            this.getSquare(i, j).setStart(false);
            this.getSquare(i, j).setEnd(false);
        }
    }
}
}
