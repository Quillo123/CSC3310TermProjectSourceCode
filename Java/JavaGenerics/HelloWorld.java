/*.
I did not write the base Bucket <T> class , or
Sand sand = new Sand();
Bucket<Sand> sandBucket = new Bucket<>(sand);
Water water = new Water();
Bucket<Water> waterBucket = new Bucket<>(water)
^
That was written by a Reddit user who no longer has an account [deleted].
at https://www.reddit.com/r/learnjava/comments/2u0ab9/really_confused_about_generics_can_somebody_eli5/
However, I wrote everything else including the Sand and Water classes, and the Print function
- Isaiah Hogue
 */

package com.example.helloworld;

class Sand{
    private int mass;
    public Sand(int x){
        this.mass = x;
    }
    public int getMass(){
        return mass;
    }
}

class Water{
    private double viscosity;
    public Water(double x){
        this.viscosity = x;
    }
    public double getViscosity(){
        return viscosity;
    }
}

class Bucket <T> {
    private T content;
    public Bucket (T content){

        this.content = content;
    }

    public T getContent() {
        return content;
    }
}




public class HelloWorld {

    public static void main(String[] args) {

        int j = 72;
        double trouble = 3.146929;
        Sand sand = new Sand(j);
        Water water = new Water(trouble);
        Bucket<Sand> tub = new Bucket<>(sand);
        Bucket<Water> pail = new Bucket<>(water);
        Print(pail.getContent().getViscosity());
        Print(tub.getContent().getMass());
    }
    public static <T> void Print(T input){
        System.out.println(input);
    }

}
/*
 * "C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2020.2.3\lib\idea_rt.jar=62658:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2020.2.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\charsets.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\ext\access-bridge-64.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\ext\cldrdata.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\ext\dnsns.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\ext\jaccess.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\ext\localedata.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\ext\nashorn.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\ext\sunec.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\ext\sunjce_provider.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\ext\sunmscapi.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\ext\sunpkcs11.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\ext\zipfs.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\jce.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\jfr.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\jsse.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\management-agent.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\resources.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\rt.jar;C:\Users\isaia\source\java\helloWorld\out\production\java" com.example.helloworld.HelloWorld
 * 3.146929
 * 72
 *
 * Process finished with exit code 0
 */
