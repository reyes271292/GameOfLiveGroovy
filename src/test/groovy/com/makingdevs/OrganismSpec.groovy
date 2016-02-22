package com.makingdevs

import spock.lang.Specification 

class OrganismSpec extends Specification{
  private Organism organism
  def setup(){
    organism=new Organism()
  }
  def "Add two numbers"(){
    given:
      Integer a=2
      Integer b=3
    when:
      def sum=organism.sumar(a,b)

    then:
      sum==5
  }
  def "given the coordinate with [1, 1], should get around set coordinates"(){
    given:
      Integer x=1
      Integer y=1
    when:
      def coordinates = organism.coordinates(x,y)
    then:
      coordinates==[[0, 0], [0, 1], [0, 2], [1, 0], [1, 2], [2, 0], [2, 1], [2, 2]]
  }
  
  def "given a cell in position [1,1] should return 8 neighbors"(){
    given:
      Integer x=1
      Integer y=1
    when:
      def neighbors = organism.find_neighbors(x,y)
    then:
      neighbors==[0,0,0,0,0,1,0,1]
  }

}