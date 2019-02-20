package mx.ipn.cic.calculadora;

import java.util.Stack;
import java.util.StringTokenizer;

public class Operaciones {

    // Constructor
    public Operaciones(){ }

    private Stack<String> digitos = new Stack<String>();
    private Stack<String> operadores = new Stack<String>();

    public String convertirPostFijo(StringTokenizer cadena) {
        String expresionPost = new String("");
        while(cadena.hasMoreElements()) {
            try {
                String element = cadena.nextToken();
                if (Character.isLetterOrDigit(element.charAt(0))) {
                    expresionPost += element + " ";
                } else if (element.equals("(")) {
                    operadores.push(element);
                } else if (element.equals(")")) {
                    while (!operadores.isEmpty() && !operadores.peek().equals("(")) {
                        expresionPost += operadores.pop() + " ";
                    } // while.
                    if (operadores.isEmpty() && operadores.peek().equals("(")) {
                        return "Math error";
                    } else {
                        operadores.pop();
                    } // else.
                } else {
                    while (!operadores.isEmpty() && pesosOperadores(element) <= pesosOperadores(operadores.peek())) {
                        expresionPost += operadores.pop() + " ";
                    }
                    operadores.push(element);
                }
            } catch (Exception e) {
                return "Math Error";
            }
        }
        while (!operadores.isEmpty()) {
            expresionPost += operadores.pop() + " ";
        }
        return expresionPost;
    }

    public String expresionFinal(StringTokenizer expresionPost) {
        Double a;
        Double b;
        Double c;
        while(expresionPost.hasMoreElements()) {
            try {
                String element = expresionPost.nextToken();
                if(isOperador(element)) {
                    if(expresionTrigonometrica(element) || element.equals("$")) {
                        a = Double.parseDouble(expresionPost.nextToken());
                        c = operacion(a, element);
                    } else {
                        b = Double.parseDouble(digitos.pop());
                        a = Double.parseDouble(digitos.pop());
                        c = operacion(a, b, element);
                    }
                    digitos.push(c.toString());
                    continue;
                } else {
                    digitos.push(element);
                }
            } catch (Exception e) {
                return "Math Error";
            }
        }
        return digitos.pop();
    } // method.

    public Integer pesosOperadores(String operador) {
        if (operador.equals("Sin")) {
            return 4;
        } else if (operador.equals("Cos")) {
            return 4;
        } else if (operador.equals("Tan")) {
            return 4;
        } else if (operador.equals("Cot")) {
            return 4;
        } else if (operador.equals("Sec")) {
            return 4;
        } else if (operador.equals("Csc")) {
            return 4;
        } else if (operador.equals("^")) {
            return 3;
        } else if (operador.equals("*")) {
            return 2;
        } else if (operador.equals("/")) {
            return 2;
        } else if (operador.equals("+")) {
            return 1;
        } else if (operador.equals("-")) {
            return 1;
        } else if (operador.equals("(")) {
            return 0;
        } else if (operador.equals(")")) {
            return 0;
        } else if(operador.equals("$")){
            return 3;
        }
        else {
            return -1;
        } // else.
    } // method.


    public Double operacion(Double a, String operador) {
        if (operador.equals("Sin")) {
            return Math.sin(a);
        } else if (operador.equals("Cos")) {
            return Math.cos(a);
        } else if (operador.equals("Tan")) {
            return Math.tan(a);
        } else if (operador.equals("Cot")) {
            return 1 / Math.tan(a);
        } else if (operador.equals("Sec")) {
            return 1 / Math.cos(a);
        } else if (operador.equals("Csc")) {
            return 1 / Math.sin(a);
        } else if(operador.equals("$")){
            return Math.sqrt(a);
        }
        else {
            return -1.0;
        }
    }

    public Double operacion(Double a, Double b, String operador) {
        if (operador.equals("^")) {
            return Math.pow(a, b);
        } else if (operador.equals("*")) {
            return a * b;
        } else if (operador.equals("/")) {
            return a / b;
        } else if (operador.equals("+")) {
            return a + b;
        } else if (operador.equals("-")) {
            return a - b;
        } else {
            return -1.0;
        }
    }

    public Boolean expresionTrigonometrica(String operador) {
        if (operador.equals("Sin")) {
            return true;
        } else if (operador.equals("Cos")) {
            return true;
        } else if (operador.equals("Tan")) {
            return true;
        } else if (operador.equals("Cot")) {
            return true;
        } else if (operador.equals("Sec")) {
            return true;
        } else if (operador.equals("Csc")) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isOperador(String operador) {
        try{
            Double.parseDouble(operador);
            return false;
        }catch(Exception e){
            return true;
        }
    }

}
