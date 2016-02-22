package com.makingdevs
class Organism{
  def cells=[]
  def next_state=[]
  Organism(){
    cells = [[0,0,0],[0,1,0],[1,0,1]]
    next_state = [[0,0,0],[0,1,0],[1,0,1]]
  }
  def sumar(a,b){
    a+b
  }

  def coordinates(x, y){
    [[x - 1, y - 1], [x - 1, y], [x - 1, y + 1],
     [x, y - 1],                 [x, y + 1],
     [x + 1, y - 1], [x + 1, y], [x + 1, y + 1]]
  }

  def find_neighbors(x, y){
    def coordinates_for_neighbors = coordinates(x, y)
    def matrix = cells
    //println "Matriz "+matrix
    def neighbors = []
    for(int fila=0;fila<matrix.size;fila++){
      for(int col=0;col<matrix.size;col++){
          if(x!=fila || y!=col){
            //println "Posicion: "+fila+" "+col
            //println "Vecinos "+matrix[fila][col]
            neighbors << matrix[fila][col]
          }
      }
    }
    neighbors
  }

  def might_die_because_has_fewer_than_two_neighbours(cell, neighbors){
    neighbors.count(1) < 2
  }
  
  def might_live_because_has_two_or_three_neighbours(cell, neighbors){
    (neighbors.count(1) >= 2 && neighbors.count(1) <= 3)
  }

  def might_die_because_has_more_than_tree_neighbours(cell,neighbors){
    neighbors.count(1) > 3
  }

  def might_reborn_because_has_exactly_three_neighbours(cell, neighbors){
    (neighbors.count(1)==3)
  }

  def next_state(){
    matrix = Matrix.rows @cells
    matrix.each_with_index do |cell, x, y|
      neighbors = find_neighbors(x, y)
      case cell
        when 1
          @next_state[x][y] = 0 if(might_die_because_has_fewer_than_two_neighbours(cell, neighbors) or might_die_because_has_more_than_tree_neighbours(cell, neighbors))
          @next_state[x][y] = 1 if(might_live_because_has_two_or_three_neighbours(cell, neighbors))
        else
          @next_state[x][y] = might_reborn_because_has_exactly_three_neighbours(cell, neighbors) ? 1 : 0
      end
    end
    @next_state
    p @next_state
  end
  }
    
}