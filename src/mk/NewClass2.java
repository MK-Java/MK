/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mk;

/**
 *
 * @author s556370
 */
 class NewClass1 {
    
    public int arg1i;
    public String arg2s;
    public float arg3f;
    public double arg4d;

   
    public void setArg1i(int arg1){
        arg1i = arg1;
    }
     public int getArg1i(){
        return arg1i;
    }

    @Override
    public String toString() {
        return "NewClass1{" + "arg1i=" + arg1i + ", arg2s=" + arg2s + ", arg3f=" + arg3f + ", arg4d=" + arg4d + '}';
    }

    public NewClass1() {
    }
    
     
    
    
    
}
class NewClass2{
    
    public static void main(String[] args) {
        NewClass1 obj1= new NewClass1();
        obj1.setArg1i(1);
        System.out.println(obj1.getArg1i());
        System.out.println(obj1.toString());
    }
    
    
}
