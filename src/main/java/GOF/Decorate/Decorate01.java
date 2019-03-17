package GOF.Decorate;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * 装饰器模式：高级流的使用模式
 *
 * 实现放大器对声音的放大功能
 *
 */
public class Decorate01 {

    public static void main(String[] args) {
        People people = new People();
        people.say();
        Amplifier amplifier = new Amplifier(people);
        amplifier.say();
    }


}


interface Voice {
    void say();
}


class People implements Voice{

    private int voice=10;//10分贝

    public void say() {
        System.out.println("人的声音为"+getVoice());
    }
    public int getVoice() {
        return voice;
    }
    public void setVoice(int voice) {
        this.voice = voice;
    }
}


class Amplifier implements Voice {

    private People p;

    Amplifier(People p) {
        this.p = p;
    }



    //同样的say方法，对人的声音做修饰
    public void say() {
        System.out.println("放大器的声音为"+p.getVoice()*100);
        System.out.println("噪音");
    }
}