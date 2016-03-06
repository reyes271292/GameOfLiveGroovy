package com.makingdevs
class OrganismCells{
  def cells=[]
  def new_state=[]
  OrganismCells(){
    this.cells = [[0,0,0],[0,1,0],[1,0,1]]
    this.new_state = [[0,0,0],[0,1,0],[1,0,1]]
  }

  def populate(cells){
    this.cells = cells
    //println cells
  }

  def evolve(){
    this.cells.eachWithIndex{ row, index->
      row.eachWithIndex{ element, indx->
        println "evolve:---"+element
      }
    }
  }
   
  def reassign(){
    this.new_state.eachWithIndex{row,x->
      this.new_state.eachWithIndex{element,j->
        this.cells[x][j] = element
      }
    }
  }
    
  
  def coordinates(x, y){
    [[x - 1, y - 1], [x - 1, y], [x - 1, y + 1],
     [x, y - 1],                 [x, y + 1],
     [x + 1, y - 1], [x + 1, y], [x + 1, y + 1]]
  }

  def find_neighbors(x, y){
    def coordinates_for_neighbors = coordinates(x, y)
    def matrix = this.cells
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

  def might_die_because_has_fewer_than_two_neighbours( neighbors){
    neighbors.count(1) < 2
  }
  
  def might_live_because_has_two_or_three_neighbours( neighbors){
    (neighbors.count(1) >= 2 && neighbors.count(1) <= 3)
  }

  def might_die_because_has_more_than_tree_neighbours(neighbors){
    neighbors.count(1) > 3
  }

  def might_reborn_because_has_exactly_three_neighbours( neighbors){
    (neighbors.count(1)==3)
  }

  def next_state(){
    def matrix = this.cells
    
    for(int fila=0;fila<matrix.size;fila++){
      for(int col=0;col<matrix.size;col++){
        def neighbors = find_neighbors(fila,col)
        //println "Vecinos: "+neighbors
        switch(matrix[fila][col]) {
          case 0:
            if(might_die_because_has_fewer_than_two_neighbours( neighbors) || might_die_because_has_more_than_tree_neighbours( neighbors)){
              this.new_state[fila][col] = 0 
              //println "0: "+fila+" "+col
            }

            else if(might_live_because_has_two_or_three_neighbours( neighbors)){
              this.new_state[fila][col] = 1 
              //println "0,1: "+fila+" "+col
            }
          break
          case 1:
            this.new_state[fila][col] = might_reborn_because_has_exactly_three_neighbours(neighbors) ? 1 : 0
            //println "1: "+fila+" "+col
          break
        }
      }
    }
    println "last next-state: "+new_state
    this.new_state
  }

  
    
}

OrganismCells organismo=new OrganismCells()
(1..3).each{
  System.out.println ("\f")
  organismo.evolve()
  organismo.next_state()
  organismo.reassign()
  sleep(1000)

}
    
  