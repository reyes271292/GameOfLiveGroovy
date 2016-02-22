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
    println "Matriz "+matrix
    int pos=0
    def neighbors = []
    coordinates_for_neighbors.each {coordinates->
      //if(x.between?(0, matrix.row_count - 1) and
      //   y.between?(0, matrix.column_count - 1)) then
      coordinates.each{
        // neighbors << cells[x][y]
        print " "+it
      }
    neighbors=[0,0,0,0,0,1,0,1]
    
    }
    neighbors
  }
    
}