package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Producto implements Comparable<Producto>{
  private String nombre;
  private String codigo;
  private List<Double> precios;
  private int porcentajeCaracteresUnicos;
  private List cantidadPreciosRepetidos;
  
  
  public Producto(String nombre, String codigo, List precios, int porcentajeCaracteresUnicos,
      List cantidadPreciosRepetidos) {
    this.nombre = nombre;
    this.codigo = codigo;
    this.precios = precios;
    this.porcentajeCaracteresUnicos = porcentajeCaracteresUnicos;
    this.cantidadPreciosRepetidos = cantidadPreciosRepetidos;
  }

  private int porcentajeCaracteresUnicos(){
    String totalCaracteres;
    int porcentajeCaracteresUnicos;

    if(nombre==null || nombre.isEmpty())
      return 0;
    totalCaracteres = (nombre.replace(" ", ""));
    Set<Character> CaracteresUnidos = new HashSet<>();
    for (Character n : totalCaracteres.toCharArray()) {
      CaracteresUnidos.add(n);
    }
    if (totalCaracteres.length()==0) {
      return 0;
    }

    return (CaracteresUnidos.size() * 100)/totalCaracteres.length();
  }

  private int cantidadPreciosRepetidos(){
    int result=0;
    if (precios.isEmpty()) {
      return 0;
    }
    for (int i=0; i<this.precios.size();i++) {
      for(int j=1; j<precios.size();j++)
      if (that.precios[i]=that.getPrecios[j]) {
        result++;
      }
    }

  return result;
  }

  public String getNombre() {
    return nombre;
  }

  public String getCodigo() {
    return codigo;
  }



  public int getPorcentajeCaracteresUnicos() {
    return porcentajeCaracteresUnicos;
  }

  @Override
  public String toString() {
    return nombre+ " - codigo=" + codigo + ", precios=" + precios
        + ", porcentajeCaracteresUnicos=" + porcentajeCaracteresUnicos + ", cantidadPreciosRepetidos="
        + cantidadPreciosRepetidos ;
  }

  @Override
  public int hashCode() {
    return Objects.hash(codigo);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Producto that = (Producto) obj;
    return codigo.equals(that.codigo);
  }

  @Override
  public int compareTo(Producto pro) {
    // TODO Auto-generated method stub
    return this.getNombre().compareTo(pro.getNombre());
  }

  

  
}
