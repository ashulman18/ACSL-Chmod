//Andrea Shulman
//ACSL CHMOD

public class Chmod
{
   private String octalNum;
   private String binary; // binary of given octal
   private int firstNum; //to check special permissions
   private String output; //final thingy
   private int count; //to help with our special permissions
   
   public Chmod(String str)
   {
      firstNum=Integer.parseInt(str.substring(0,str.indexOf(",")));
      str=str.substring(str.indexOf(",")+1);
      String temp="";
      output="";
      count=1;
      for(int i=0;i<str.length();i++)
      {
         if(!((str.substring(i,i+1))).equals(","))
            temp+=str.substring(i,i+1);
      }
      octalNum=temp;
      binary=octToBin(octalNum);
      chmodCommand();
      System.out.println(output);
   }
   
   public void chmodCommand()
   {
      String bin1=binary.substring(0,3);
      String bin2=binary.substring(3,6);
      String bin3=binary.substring(6);
      binary=bin1+" "+bin2+" "+bin3;
      String chmods= binToChmod(bin1)+" ";
      count++;
      chmods+=binToChmod(bin2)+" ";
      count++;
      chmods+=binToChmod(bin3);
      output=(binary+" and "+chmods);
   }
   
   public void firstNumCheck()
   {
      String temp=output;
      if(firstNum==1)//owner
         output=output.replace('x','s');
      else if(firstNum==2)//group
         output=output.replace('x','s');
      else if(firstNum==4)//other
         output=output.replace('x','t');
   }
   
   //make the octal into binary
   public String octToBin(String str)
   {
      int num=Integer.parseInt(str.substring(0,1));
      String temp="";
      String tempBin;
      for(int i=0;i<str.length();i++)
      {
         num=Integer.parseInt(str.substring(i,i+1));
         tempBin=""+Integer.toBinaryString(num);
         //ensure it is 3 digits long
         while(tempBin.length()<3)
            tempBin="0"+tempBin;
         temp+=tempBin;
      }
      return temp;
   }
   
   //second half of the output
   public String binToChmod(String str)
   {
      String perm="";
      if(str.substring(0,1).equals("1"))
         perm+="r";
      else
         perm+="-";
      if(str.substring(1,2).equals("1"))
         perm+="w";
      else
         perm+="-";
      if(str.substring(2).equals("1"))
         perm+="x";
      else
         perm+="-";
      //checks for special permissions
      if(firstNum==1&& count==1)//owner
         perm=perm.replace('x','s');
      else if(firstNum==2&& count==2)//group
         perm=perm.replace('x','s');
      else if(firstNum==4&& count==3)//other
         perm=perm.replace('x','t');
      return perm;
   }   
   public static void main(String[]args)
   {
      Chmod test1= new Chmod("4,2,4,7");
      Chmod test2=new Chmod("0,1,5,4");
      Chmod test3=new Chmod("1,7,3,1");
      Chmod test4=new Chmod("2,6,7,3");
      Chmod test5=new Chmod("4,7,4,5");
   }
   
   /*
   010 100 111 and -w- r-- rwt
   001 101 100 and --x r-x r--
   111 011 001 and rws -wx --x
   110 111 011 and rw- rws -wx
   111 100 101 and rwx r-- r-t
   */ 
   
}