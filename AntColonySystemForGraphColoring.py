# -*- coding: utf-8 -*-
"""Programa4.ipynb

Automatically generated by Colaboratory.

Original file is located at
    https://colab.research.google.com/drive/1mai14n6sfg6hM_RpwKhmoooZUXEZXX5K
"""

import numpy as np
import math
import matplotlib.pyplot as plt
import networkx as nx
import random

class Graph():
  
  def __init__(self):
    self.colores = {0:"white",1:"red",2:"blue",3:"green",4:"yellow",5:"purple",6:"brown",7:"orange",8:"silver",9:"gold",10:"grey"}
    self.G = nx.Graph()
    self.graficaAleatoria()
    self.ColorActual = dict()
    
  def graficaAleatoria(self):
    numNodos = 10 #np.random.randint(50) + 50
    for i in range(0,numNodos):
      self.G.add_node(i)
    for i in range(0, numNodos):
      listaNodo = [item for item in self.G.edges() if i in item]
      numAristas = np.random.randint(5) + 5
      if(len(listaNodo) <= numAristas):
        listaNoVecinos = set(range(0,numNodos))-set(self.G.adj[i])
        aux = random.sample(listaNoVecinos, numAristas-len(listaNodo))
        for j in aux:
          self.G.add_edge(i, j)

  def MXRLF(self):
    colores2 = list()
    for i in range(0,len(list(self.G.nodes))):
      coloresDisponibles = set(self.colores.values())
      for e in self.G.adj[i]:
        coloresUsados = set()
        if(e in self.ColorActual):
          coloresUsados.add(self.ColorActual[e])
      colores2.append(random.sample(list(coloresDisponibles.difference(coloresUsados)),1)[0])
    return colores2


  def ColourVertex(self,i,k,Ck,X,F):
    auxi = set()
    auxi.add(i)
    X = X.difference(auxi)
    Ck = Ck.union(auxi)
    VecinosEnG = set(self.G.adj[i])
    GammaF = F.intersection(VecinosEnG)
    GammaF = GammaF.union(auxi)
    F = F.difference(GammaF)
      
  def toString(self,colores):
    pos = nx.spring_layout(self.G)
    options = {"node_size": 500, "alpha": 0.8}
    nx.draw_networkx_nodes(self.G, pos, nodelist=list(self.G.nodes), node_color=colores, **options,with_labels=True)
    nx.draw_networkx_edges(self.G, pos, width=1.0, alpha=0.5)
    plt.draw()
    
graficaPrueba = Graph()
graficaPrueba.graficaAleatoria()
graficaPrueba.toString(graficaPrueba.MXRLF())
#PropuestaDeSolucion = graficaPrueba.algoritmo_no_determinista()
#PropuestaDeSolucion.toString()
#PropuestaDeSolucion.VerificaSolucion(5)
plt.show()
