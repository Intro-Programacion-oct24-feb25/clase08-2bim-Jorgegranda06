/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo002;
/**
 *
 * @author reroes
 */
public class Principal1 {

    public static void main(String[] args) {
        
        String [] nombres = { "Jason", "Jonathan", "Kristen", "Robin", 
            "Michelle", "Emily", "Noah", "Daniel"};
        String [] apellidos = { "Lynch", "George", "Lang", "Cochran", 
            "Young", "Fletcher", "Adkins", "Harris"};
        int [][] notas = { {10, 80, 80, 95}, {40, 80, 80, 45}, {80, 10, 20, 55}, 
            {70, 30, 20, 65}, 
            {60, 50, 70, 75}, {50, 70, 30, 85},{40, 80, 40, 45}, 
            {30, 90, 50, 95}};
        
        double promedio_paralelo = obtenerPromedioParalelo(notas);
        String nombre;
        String apellido;
        String tipoNotas;
        String username;
        double promedioEstudiante;
        int numeroNotasArribaPromedio;
        int [] filaNotas;
        int notasMenor;
        int notaMayor;
        String mensajeFinal = "";
        for (int i = 0; i < nombres.length; i++) {
            nombre = nombres[i];
            apellido = apellidos[i];
            username = obtenerUsername(nombre, apellido);
            filaNotas = notas[i];
            promedioEstudiante = funcion01(filaNotas);
            numeroNotasArribaPromedio = funcion02(filaNotas, 
                    promedio_paralelo);
            notasMenor = funcion04(filaNotas);
            notaMayor = funcion05(filaNotas);
            tipoNotas = funcion03(filaNotas);
            mensajeFinal = String.format("%s%s\n", mensajeFinal, 
                    presentarReporte(nombre, apellido, tipoNotas, 
                    promedioEstudiante, numeroNotasArribaPromedio, username,
                    notasMenor, notaMayor));
        }
        CrearArchivoTexto.agregarRegistros(mensajeFinal);

    }
    
    public static String presentarReporte(String nom, String ap, String notas, 
            double prom, int numeroNotas, String username, int a, int b){
        String reporte = String.format("Nombres: %s\n"
                + "Apellidos: %s\n"
                + "Username: %s\n"
                + "Con notas: \n"
                + "%s\n"
                + "Promedio - %2f\n"
                + "Número de notas arriba del promedio: %d\n"
                + "Nota mas baja -"
                + "Nota mas alta -",
                nom, ap, username, notas, prom, numeroNotas, a, b);
        
        return reporte;
    }

    
    public static double obtenerPromedioParalelo(int [][] n){
        int suma = 0;
        double promedio;
        int contador = 0;
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[0].length; j++) {
                suma = suma + n[i][j];
                contador = contador + 1;
            }
        }
        
        promedio = (double)suma/ contador;
        return promedio;
    }
    
    public static double funcion01(int [] notas){
        int suma = 0;
        double promedio;
        for (int i = 0; i < notas.length; i++) {
            suma = suma + notas[i];
        }
        promedio = (double) suma / notas.length;
        return promedio;
    }
    
    public static int funcion02(int [] notas, double promedio){
        
        int contador = 0;
        int nota;
        for (int i = 0; i < notas.length; i++) {
            nota = notas[i];
            if (nota > promedio) {
                contador = contador + 1;
            }
            
        }
        
        return contador;
    }
    
    public static String funcion03(int [] notas){
        String cadena = "";
        
        int nota;
        for (int i = 0; i < notas.length; i++) {
            nota = notas[i];
            if (nota >=0 && nota<=20) {
                cadena = String.format("%s%d-%s\n", cadena, nota, "M");
            }else{
                if (nota >20 && nota<=50) {
                    cadena = String.format("%s%d-%s\n", cadena, nota, "MB");
                }else{
                    if (nota > 50) {
                        cadena = String.format("%s%d-%s\n", cadena, nota, "S");
                    }
                }
            }
            
        }
        
        return cadena;
    }
    
    public static String obtenerUsername(String a , String b){
        
        String cadena;
        String inicial = a.substring(0,1);
        String apellido = b.toLowerCase();
        inicial = inicial.toLowerCase();
       
        cadena = String.format ("%s.%s@utpl.edu.ec", inicial, 
                apellido);
        return cadena;
    }
    
    public static int funcion04(int [] a){
        int menor = 0;
        for (int i = 0; i < a.length; i++){
            if (menor < a[i]){
                menor = a[i];
            }
        }
        return menor;
    }
    
    public static int funcion05(int [] a){
        int mayor = 0;
        for (int i = 0; i < a.length; i++){
            if (mayor < a[i]){
                mayor = a[i];
            }else{
                mayor = a[i];
            }
        }
        return mayor;
    }
}
    
   /* este codigo nos ayuda a tener un listado de notas de los estudiantes nos
    asigna una letra a nuestra nota dependiendo de nuestra calificacion y ya 
    este se guarda en un archivo data
    */
    
    

