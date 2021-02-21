
/**
 * Write a description of class ListaNumeros here.
 * 
 * @author sercadel
 * @version 0.1
 */

import java.util.Arrays;

public class ListaNumeros
{
    private int[] lista;
    private int elementos;

    /**
     * Constructor para objetos de clase ListaNumeros
     */
    public ListaNumeros(int [] lista)
    {
        this.lista = lista;
        elementos = lista.length;
    }
    
    /**
     * Constructor para objetos de clase ListaNumeros
     */
    public ListaNumeros(int lista)
    {
        this.lista = new int[lista];
        
        elementos = 0;
    }

    /**
     * Añade el valor recibido como parámetro al final de la lista
     * 
     * @param  i   valor que se añade a la lista
     *
     */
    public void anadirElemento(int valor)
    {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == 0) {
                lista[i] = valor;
                elementos++;
                break;
            }
        }
    }
    
    /**
     * Devuelve el número de elementos guardados en la lista
     * 
     * @return      Número de elementos en la lista
     *
     */
    public int getTotalNumeros()
    {
        int auxiliar = 0;
        
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] > 0) {
                auxiliar++;
            }
        }
        
        return auxiliar;
    }
    
    /**
     * Añade a cada elemento del array el valor de su posición
     *
     */
    public void sumarPosicion()
    {        
        for (int i = 0; i < lista.length; i++) {
            lista[i] = lista[i] + i;
        }
    }
    
    /**
     * Devuelve el valor mínimo la lista
     * 
     * @return      Valor mínimo de la lista
     *
     */
    public int obtenerMinimo()
    {
        int resultado = lista[0];
        
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] < resultado && lista[i] > 0) {
                resultado = lista[i];
            }
        }
        
        return resultado;
    }
    
    /**
     * Devuelve el número de valores mínimos de la lista
     * 
     * @return      Número de valores mínimos de la lista
     *
     */
    public int cuantosMinimos()
    {
        int minimo = obtenerMinimo();
        
        int auxiliar = 0;
        
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == minimo) {
                auxiliar++;
            }
        }
        
        return auxiliar;
    }
    
    /**
     * Devuelve un array con los valores mínimos de la lista
     * 
     * @return      Array con los valores mínimos de la lista
     *
     */
    public int[] generarArrayMinimos()
    {
        int contador = 0;
        
        int minimo = obtenerMinimo();
        
        int[] arrayMinimos = new int[cuantosMinimos()];
        
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == minimo) {
                arrayMinimos[contador] = lista[i];
                contador++;
            }
        }
        
        return arrayMinimos;
    }
    
    /**
     * Borra de lista todos los valores que sean múltiplos del parámetro
     *
     * @param  n   valor que se borrará de la lista
     */
    public void borrarMultiplosDe(int n)
    {        
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] % n == 0) {
                borrarUno(i);
            }
        }
        
        int[] arrayAux = new int[getTotalNumeros()];
        
        int contador = 0;
        
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] > 0) {
                arrayAux[contador] = lista[i];
                contador++;
            }
        }
        
        lista = arrayAux;
        
        elementos = lista.length;
    }
    
    /**
     * Borra un elemento de la lista
     *
     * @param  n   índice del valor que se borrará de la lista
     */
    private void borrarUno(int n)
    {        
        lista[n] = 0;
    }
    
    /**
     * Muestra en pantalla la lista
     *
     */
    public void escribirLista()
    {        
        System.out.println(toString());
    }
    
    /**
     * Devuelve una cadena con la representación de la lista
     * 
     * @return      cadena con la representación de la lista
     *
     */
    public String toString()
    {
        String auxiliar = "{";
        
        int contadorComas = getTotalNumeros();
        
        for (int i = 0; i < lista.length; i++) {
            
            if (lista[i] > 0) {
                auxiliar += lista[i];
                //if (i < lista.length -1) {
                if (contadorComas > 1) {
                    auxiliar += ", ";
                    contadorComas--;
                }
            }
        }
        
        return auxiliar += "}";
    }
    
    /**
     * Devuelve una copia de la lista
     * 
     * @return      Array copia de la lista
     *
     */
    public int[] copiar()
    {
        int[] copiaArray = Arrays.copyOf(lista, elementos);
        
        return copiaArray;
    }
    
    /**
     * Devuelve una cadena con los valores de la lista que están entre las posiciones from hasta to
     * 
     * @return      cadena con los valores de la lista que están entre from y to
     *
     */
    public String copiarRango(int from, int to)
    {   
        String cadena = "{";
        
        int contadorComas = getTotalNumeros();
        
        if (to - from >= 0 && indiceCorrecto(from) == true) {
            
            // Si to es mayor a la longitud de la lista
            if (to > lista.length) {
                // establece to a la longitud de la lista
                to = lista.length;
            }
            
            for (int i = from; i < to; i++) {
                if (lista[i] > 0) {
                    cadena += lista[i];
                    if (i < to -1) {
                    //if (contadorComas > 1) {
                        cadena += ", ";
                        contadorComas--;
                    }
                }
            }
            cadena += "}";
            
        } else {
            cadena = "Índice incorrecto, no se ha podido copiar.";
        }
        
        return cadena;
    }
    
    /**
     * Devuelve booleano si el índice es correcto o no
     * 
     * @return      booleano 
     *
     */
    private boolean indiceCorrecto(int pos)
    {   
        boolean resultado = false;
        
        if (pos >= 0) {
            
            resultado = true;
            
        }
        
        return resultado;
    }
}
