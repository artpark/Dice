import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

//Art Parkeenvincha, Block 3, Dice
Die one, two, three;
int total;
String totalString = "";
public void setup()
{  
  size(500, 500);
  noLoop();
  rectMode(CENTER);
  textSize(15);
  colorMode(HSB);
}

public void draw()
{
  background(255);
  smooth();

  for (int a = 0; a < 480; a += 20) {
    for (int b = 0; b < 500; b += 20) {
      one = new Die(10+b, 10+a);
      one.roll();
      one.show();
    }
  }

  totalString = totalString + total; 
  fill(0);
  text("Total: " + totalString, 5, 495);
  total = 0;
  totalString = "";
}
public void mousePressed()
{
  redraw();
}
class Die //models one single dice cube
{
  int myX, myY, faceNum;
  Die(int x, int y) //constructor
  {
    myX = x;
    myY = y;
  }
  public void roll()
  {
    faceNum = (int)(Math.random()*6)+1;
    total += faceNum;
  }
  public void show()
  {
    fill(255);
    rect(myX, myY, 20, 20, 5);
    fill(0);
    noStroke();
    if (faceNum == 1) {
      fill((int)(Math.random()*255), 255, 255);  
      ellipse(myX, myY, 3, 3);
    }
    if (faceNum == 2) {
      ellipse(myX+4, myY-4, 3, 3);
      ellipse(myX-4, myY+4, 3, 3);
    }
    if (faceNum == 3) {
      ellipse(myX, myY, 3, 3);
      ellipse(myX+4, myY-4, 3, 3);
      ellipse(myX-4, myY+4, 3, 3);
    }
    if (faceNum == 4) {
      ellipse(myX+4, myY-4, 3, 3);
      ellipse(myX+4, myY+4, 3, 3);
      ellipse(myX-4, myY-4, 3, 3);
      ellipse(myX-4, myY+4, 3, 3);
    }
    if (faceNum == 5) {
      ellipse(myX, myY, 3, 3);
      ellipse(myX+4, myY-4, 3, 3);
      ellipse(myX+4, myY+4, 3, 3);
      ellipse(myX-4, myY-4, 3, 3);
      ellipse(myX-4, myY+4, 3, 3);
    }
    if (faceNum == 6) {
      ellipse(myX+4, myY, 3, 3);
      ellipse(myX-4, myY, 3, 3);
      ellipse(myX+4, myY-4, 3, 3);
      ellipse(myX-4, myY-4, 3, 3);
      ellipse(myX+4, myY+4, 3, 3);
      ellipse(myX-4, myY+4, 3, 3);
    }
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
