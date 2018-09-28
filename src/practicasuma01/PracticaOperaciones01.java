/*
 * To change this license header, choose License Headers in Project Properties.To change this template file, choose Tools | Templates, and open the template in the editor.
 */
package practicasuma01;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Citla
 */


public class PracticaOperaciones01 {

    
    public static void main(String[] args) {
         
    // MANIPULAR DOS NÚMEROS DE OTRAS CLASES (SUMA, RESTA, MULTIPLICACIÓN, DIVISIÓN)
        
        //INSTANCIAMOS LOS NÚMEROS DE LAS OTRAS CLASES
        Entero1 num1 = new Entero1(); //Creamos un objeto (num1) de la clase Entero1
        num1.getN1(); //Le asignamos valor al objeto, que obtenemos de la variable n1 (creado en Entero1)
        System.out.println("Numero 1 (a): " + num1.getN1()); //Imprimimos para comprobar que se le asignó el valor
        
        Entero2 num2 = new Entero2();//Mismo procedimiento con num2 y Entero2
        num2.getN2();//Le asignamos valor al objeto, que obtenemos de la variable n2 (creado en Entero2)
        System.out.println("Numero 2 (b): " + num2.getN2());//Imprimimos para comprobar que se le asignó el valor
        
        //SUMA SIN MÉTODO
        System.out.println("La suma es: " + (num1.getN1()  + num2.getN2()));//Hacemos la suma de las variables
        int a = num1.getN1();//Simplificamos el nombre de las variables a sumar
        int b = num2.getN2();
        System.out.println("La suma simplificada es: " + (a + b));
        //SUMA CON MÉTODO
        Operaciones sumar = new Operaciones();//Creamos objeto de tipo Operaciones
        sumar.sumar(a, b);// Con el nuevo objeto mandamos llamar la función sumar
        System.out.println("Suma con método sumar: " + sumar.sumar(num1.getN1(), num2.getN2()));//Imprimimos suma
        System.out.println("Suma con método sumar simplificado: " + sumar.sumar(a, b));
        int c = 15;//Creamos dos variables nuevas para hacer otras operaciones
        int d = 10;
        System.out.println("Otra suma con método sumar(nuevas variables): " + sumar.sumar(c,d));
        
        //MULTIPLICAR (CON MÉTODO LOCAL)
        PracticaOperaciones01 multiplicar = new PracticaOperaciones01();//Creamos objeto de tipo PracticaOperaciones01
        multiplicar.multiplicacion(a, b);//Con el nuevo objeto mandamos llamar la función multiplicar
        System.out.println("Multiplicación: " + multiplicar.multiplicacion(a, b) );
        System.out.println("Multiplicación: " + multiplicar.multiplicacion(c, d) );
        
        
        //RESTAR (CON MÉTODO)
        Operaciones restar = new Operaciones();
        restar.restar(a, b);// Con el nuevo objeto mandamos llamar la función restar
        System.out.println("Resta con método: " + restar.restar(a, c));
        System.out.println("Resta negativa con método: " + restar.restar(b, c));
        
        //DIVIDIR (CON MÉTODO)
        Operaciones mDividir = new Operaciones();
        mDividir.dividir(a, b);//con el nuevo objeto llamamos al método creado en la clase Operaciones
        System.out.println("División: " + mDividir.dividir(d, b));
        
        //EJERCICIO 01 (Comprar números)
        System.out.println("Ingrese primer número a comprar");
        Scanner Scan = new Scanner(System.in);
        int var1 = Scan.nextInt();
        System.out.println("Ingrese segundo número a comprar");
        int var2 = Scan.nextInt();
        
        if(var1==var2){
            System.out.println( var1 + " y "+ var2 + " son iguales :v");
        }else if (var1>var2){
            System.out.println(var1 + " es mayor");
        }
        else{
            System.out.println(var2 + " es mayor");
        }   
        
        
        //EJERCICIO 02
        System.out.println("Ingrese el numero a dividir");
        Scanner Scan2 = new Scanner(System.in);
        double var3 = Scan2.nextDouble();
       
        System.out.println("¿Entre cuánto lo vamos a dividir?");
        double var4 = Scan2.nextDouble();
        if(var3 != 0 && var4 !=0){
            double resultado = mDividir.dividir(var3, var4);//HACEMOS LA OPERACIÓN Y ASIGNAMOS EL RESULTADO A LA VARIABLE
            System.out.println("El resultado completo es: " + resultado);//Resultado con decimales completos
            
            //Limitamos el número de decimales con diferentes métodos
            //PRIMER MÉTODO
            System.out.print("Resultado con '%.2f': ");
            System.out.printf("Texto de prueba: %.2f", resultado);//no puedo mucho texto extra
            System.out.println("");
            
            //SEGUNDO MÉTODO
            DecimalFormat decimalFormat = new DecimalFormat("0.##");//Importamos DecimalFormat
            System.out.println("Resultado con 'DecimalFormat(\"0.##\")': " + decimalFormat.format(resultado));
            
            //TERCER MÉTODO
            // myFloat = (float) resultado;//casteamos resultado a FLOAT EN CASO DE QUE NO SEA FLOAT
            String formattedString = String.format("%.02f", resultado);//Le damos formato y lo asignamos a un String    
            System.out.println("Resultado con 'String.format(\"%.02f\", resultado)': " + formattedString);
            
            //CUARTO MÉTODO
            String resultado2 = Double.valueOf(resultado).toString();//convertimos resultado a STRING
            BigDecimal bigDecimal = new BigDecimal(resultado2); //Importamos BigDecimal
            bigDecimal = bigDecimal.setScale(2, bigDecimal.ROUND_HALF_UP);
            System.out.println("Resultado con 'bigDecimal.setScale(2, bigDecimal.ROUND_HALF_UP);: " + bigDecimal);
            //QUINTO MÉTODO
            String resultadoString = String.valueOf(resultado); //otra forma de convertirlo a STRING
            BigDecimal bigDecimal2 = new BigDecimal(resultado); //Importamos BigDecimal
            bigDecimal2 = bigDecimal2.setScale(2, bigDecimal2.ROUND_HALF_UP);
            System.out.println("Resultado con 'bigDecimal2': " + bigDecimal2);
            
            
        }else{
            System.out.println("Que no pongas 0, sabeee");
        }
        
        for(int i=1 ; i<=50; i++){ 
            //System.out.print(contador + ", "); //contador de 1 a 50 
            if(i%2==0)//cada vez que el residuo de la división entre 10 sea 1 hace salto de página 
                System.out.println(i); 
            } 
        
        
    }
    //Método local MULTIPLICAR
    public int multiplicacion(int a,int b){//No importa el orden del método, pues al llamarlo lo mandas buscar
        return a*b;
    }
    
}
