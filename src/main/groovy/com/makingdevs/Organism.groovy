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
    for(int fila=0;fila<matrix.size;fila++){
      for(int col=0;col<matrix.size;col++){
          println "Valores : "+x+" "+y
          
          if(!matrix[x][y]){
            println "Vecinos "+matrix[fila][col]
            neighbors << matrix[fila][col]
          }
          
          
      }
    }
    println "---- "+neighbors
    neighbors
  }
    
}