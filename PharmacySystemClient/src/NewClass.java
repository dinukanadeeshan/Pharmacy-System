
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class NewClass {
    public static void main(String[] args) {
       final  SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss aa");
        Calendar c = Calendar.getInstance();
        System.out.println(sdf.format(c.getTime()));
        c.add(Calendar.MINUTE, 1);
        System.out.println(sdf.format(c.getTime()));
        Timer t = new Timer();
        System.out.println(System.currentTimeMillis());;
        t.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("hai... :D "+System.currentTimeMillis());
                System.out.println(sdf.format(new Date()));
            }
        }, 5000);
       t.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("Woow....");
                System.out.println(sdf.format(new Date()));
            }
        }, c.getTime());
        System.out.println("Dinuka");
    }
}
