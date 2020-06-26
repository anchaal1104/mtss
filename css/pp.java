import java.util.Arrays; 
import java.util.*;
class Passenger {
String gender;//Passenger Gender
String name;//Passenger Name
String airline;//Passenger Airline
int no_luggage;//No of Luggage passenger has
int time;//Time needed to complete checkin
Passenger next;
public Passenger(String gender,String name,String airline,int no_luggage)
{
this.gender=gender;
this.name=name;
this.airline=airline;
this.no_luggage=no_luggage;
time=5*no_luggage;
next=null;
}
}
class Queue{
int nPass;
Passenger first,last;
public Queue()
{
first=null;
last=null;
nPass=0;
}
public void insert(String gender,String name,String airline,int no_luggage)
{
Passenger pass=new Passenger(gender,name,airline,no_luggage);
if(first==null)
{
first=pass;
last=pass;
}
else
{
last.next=pass;
last=pass;
}
nPass=nPass+1;
}
public Passenger delete()
{
Passenger temp=first;
first=first.next;
return temp;
}
public boolean isEmpty()
{
if(first==null && last==null)
return true;
else
return false;
}
}
class checkIn_counter
{
public static Queue indian_airlines[]=new Queue[5];//Queue's for Indian Airlines
public static Queue air_india[]=new Queue[5];//Queue's for Air India Airlines
public static Queue indigo[]=new Queue[4];//Queue's for Indigo Airlines
public static Queue vistara[]=new Queue[4];//Queue's for Vistara Airlines
static Queue security_male[]=new Queue[3];//Male Security check booths
static Queue security_female[]=new Queue[2];//female Security CheckBooth's
public static void initialize()//It initialize all the Queue's
{
for(int i=0;i<5;i++)
{
indian_airlines[i]=new Queue();
air_india[i]=new Queue();
}
for(int i=0;i<4;i++)
{
indigo[i]=new Queue();
vistara[i]=new Queue();
}
for(int i=0;i<2;i++)
{
security_female[i]=new Queue();
}
for(int i=0;i<3;i++)
{
security_male[i]=new Queue();
}
}
//Function to insert any customer of Indian Airlines
public static void insert_indian_airlines(String gender,String name,String airline,int no_luggage )
{
if(indian_airlines[0].nPass==0)
{
indian_airlines[0].insert(gender,name,airline,no_luggage);
}
else if(indian_airlines[1].nPass==0)
{
indian_airlines[1].insert(gender,name,airline,no_luggage);
}
else if(indian_airlines[2].nPass==0)
{
indian_airlines[2].insert(gender,name,airline,no_luggage);
}
else if(indian_airlines[3].nPass==0)
{
indian_airlines[3].insert(gender,name,airline,no_luggage);
}
else if(indian_airlines[4].nPass==0)
{
indian_airlines[4].insert(gender,name,airline,no_luggage);
}
else
{
int min=indian_airlines[0].nPass;
int pos=0;
for(int i=0;i<5;i++)
{
if(indian_airlines[i].nPass<min)
{
min=indian_airlines[i].nPass;
pos=i;
}
}
indian_airlines[pos].insert(gender,name,airline,no_luggage);
}
}
public static void insert_air_india(String gender,String name,String airline,int no_luggage )
{
if(air_india[0].nPass==0)
{
air_india[0].insert(gender,name,airline,no_luggage);
}
else if(air_india[1].nPass==0)
{
air_india[1].insert(gender,name,airline,no_luggage);
}
else if(air_india[2].nPass==0)
{
air_india[2].insert(gender,name,airline,no_luggage);
}
else if(air_india[3].nPass==0)
{
air_india[3].insert(gender,name,airline,no_luggage);
}
else if(air_india[4].nPass==0)
{
air_india[4].insert(gender,name,airline,no_luggage);
}
else
{
int min=air_india[0].nPass;
int pos=0;
for(int i=0;i<5;i++)
{
if(air_india[i].nPass<min)
{
min=air_india[i].nPass;
pos=i;
}
}
air_india[pos].insert(gender,name,airline,no_luggage);
}
}
public static void insert_vistara(String gender,String name,String airline,int no_luggage )
{
if(vistara[0].nPass==0)
{
vistara[0].insert(gender,name,airline,no_luggage);
}
else if(vistara[1].nPass==0)
{
vistara[1].insert(gender,name,airline,no_luggage);
}
else if(vistara[2].nPass==0)
{
vistara[2].insert(gender,name,airline,no_luggage);
}
else if(vistara[3].nPass==0)
{
vistara[3].insert(gender,name,airline,no_luggage);
}
else if(vistara[4].nPass==0)
{
vistara[4].insert(gender,name,airline,no_luggage);
}
else
{
int min=vistara[0].nPass;
int pos=0;
for(int i=0;i<5;i++)
{
if(vistara[i].nPass<min)
{
min=vistara[i].nPass;
pos=i;
}
}
vistara[pos].insert(gender,name,airline,no_luggage);
}
}
public static void insert_indigo(String gender,String name,String airline,int no_luggage )
{
if(indigo[0].nPass==0)
{
indigo[0].insert(gender,name,airline,no_luggage);
}
else if(indigo[1].nPass==0)
{
indigo[1].insert(gender,name,airline,no_luggage);
}
else if(indigo[2].nPass==0)
{
indigo[2].insert(gender,name,airline,no_luggage);
}
else if(indigo[3].nPass==0)
{
indigo[3].insert(gender,name,airline,no_luggage);
}
else if(indigo[4].nPass==0)
{
indigo[4].insert(gender,name,airline,no_luggage);
}
else
{
int min=indigo[0].nPass;
int pos=0;
for(int i=0;i<5;i++)
{
if(indigo[i].nPass<min)
{
min=indigo[i].nPass;
pos=i;
}
}
indigo[pos].insert(gender,name,airline,no_luggage);
}
}
public static int findmaxlagguage()
{
int max=0;
int lagguage[]=new int[9];
for(int i=0;i<4;i++)
{
int highesttotal=0;
Passenger temp1=indigo[i].first;
Passenger temp2=vistara[i].first;
int total=0;
int total1=0;
while(temp1!=null)
{
total+=temp1.no_luggage;
temp1=temp1.next;
}
while(temp2!=null)
{
total1+=temp2.no_luggage;
temp2=temp2.next;
}
if(total>total1)
highesttotal=total;
else if(total==total1)
highesttotal=total;
else
highesttotal=total1;
lagguage[i]=total;
}
for(int i=0;i<5;i++)
{
int highesttotal=0;
Passenger temp1=air_india[i].first;
Passenger temp2=indian_airlines[i].first;
int total=0;
int total1=0;
while(temp1!=null)
{
total+=temp1.no_luggage;
temp1=temp1.next;
}
while(temp2!=null)
{
total1+=temp2.no_luggage;
temp2=temp2.next;
}
if(total>total1)
highesttotal=total;
else if(total==total1)
highesttotal=total;
else
highesttotal=total1;
lagguage[i+4]=total;
}
Arrays.sort(lagguage);
max=lagguage[lagguage.length-1];
return max;
}
}
//Indigo Checkin Booth 1
//It scans a customer standing in the first indigo queue the check the customer lagguage and then sends the customer to appropriate security check booth
//according to the gender
class indigo1  extends checkIn_counter
{
public void run()
{
try
{
while(!indigo[0].isEmpty())
{
int time=indigo[0].first.time*1000;// get the checkIn time for particular customer according to luggage
Passenger temp=indigo[0].delete();
System.out.println("\n\t" +temp.name+" has been checked by "+temp.airline +" having no of lagguage "+temp.no_luggage+" booth1");
Thread.sleep(time);
System.out.println("\n\t" +temp.name+" you have been checked out");
if(temp.gender.equalsIgnoreCase("male"))
{
int min=security_male[0].nPass;
int pos=0;
for(int i=0;i<3;i++)
{
if(security_male[i].nPass<min)
{
min=security_male[i].nPass;
pos=i;
}
}
System.out.println("\n\t" +temp.name+" Please go to male check booth "+pos);
security_male[pos].insert(temp.gender,temp.name,temp.airline,temp.no_luggage);
}
else
{
int min=security_female[0].nPass;
int pos=0;
for(int i=0;i<2;i++)
{
if(security_female[i].nPass<min)
{
min=security_female[i].nPass;
pos=i;
}
}
System.out.println("\n\t" +temp.name+" Please go to female check booth "+pos);
security_female[pos].insert(temp.gender,temp.name,temp.airline,temp.no_luggage);
}
}
}
catch (Exception e)
{
}
}
}
//Main class which implies and run the program
class ppproject 
{
//main function of the program
public static void  main(String[] args)
{
Scanner sc=new Scanner(System.in);//creation of the scanner class object
int time1 = 0;
String name,gender,airline;//declaration of string variable
int n;
int ch = 0;
char choice;
checkIn_counter.initialize();
System.out.println("\t*****Welcome To Biju Pattanaik International Airport*****");
do{//begin of do loop for passenger checkIn
System.out.println("------------------------------------------------------------------");
do //begin of 2nd Do loop for queries inputs
{
System.out.println("\t\t-------Querier--------");
System.out.println("\tPress 1 for checkin to AIR INDIA");
System.out.println("\tPress 2 for checkin to VISTARA");
System.out.println("\tPress 3 for checkin to INDIAN AIRLINES");
System.out.println("\tPress 4 for checkin to INDIGO");
System.out.println("\tPress 5 for proceding to CheckIn counter");
System.out.println("\n\t Please enter your choice");// Ask for the input for the switch case statement
ch=sc.nextInt();//initial use for the switch case
switch(ch)//begining of the switch case
{
case 1://starting of case 1
System.out.println("Enter your name");
name=sc.next();
System.out.println("Enter your gender");
gender=sc.next();
airline="AIR INDIA";
System.out.println("Enter the no of lagguage");
n=sc.nextInt();
checkIn_counter.insert_air_india(gender,name,airline,n);
break;
case 2://starting of case 2
System.out.println("Enter your name");
name=sc.next();
System.out.println("Enter your gender");
gender=sc.next();
airline="VISTARA";
System.out.println("Enter the no of lagguage");
n=sc.nextInt();
checkIn_counter.insert_vistara(gender,name,airline,n);
break;
case 5:  time1=checkIn_counter.findmaxlagguage();
Thread object = new Thread(new checkIn_counter.indigo1());
object.start();
Thread object2= new Thread(new checkIn_counter.indigo2());
object2.start();
Thread object1 = new Thread(new checkIn_counter.indigo3());
object1.start();
Thread object3 = new Thread(new checkIn_counter.indigo4());
object3.start();
Thread object4 = new Thread(new checkIn_counter.indian2());
object4.start();
Thread object5= new Thread(new checkIn_counter.indian3());
object5.start();
Thread object6 = new Thread(new checkIn_counter.indian1());
object6.start();
Thread object7 = new Thread(new checkIn_counter.indian4());
object7.start();
Thread object8 = new Thread(new checkIn_counter.indian5());
object8.start();
Thread object9= new Thread(new checkIn_counter.airindia1());
object9.start();
Thread object10 = new Thread(new checkIn_counter.airindia2());
object10.start();
Thread object11 = new Thread(new checkIn_counter.airindia3());
object11.start();
Thread object12 = new Thread(new checkIn_counter.airindia4());
object12.start();
Thread object13= new Thread(new checkIn_counter.airindia5());
object13.start();
Thread object14 = new Thread(new checkIn_counter.vistara1());
object14.start();
Thread object15 = new Thread(new checkIn_counter.vistara2());
object15.start();
Thread object16 = new Thread(new checkIn_counter.vistara3());
object16.start();
Thread object17= new Thread(new checkIn_counter.vistara4());
object17.start();
ch=7;
break;
case 3:System.out.println("Enter your name");
name=sc.next();
System.out.println("Enter your gender");
gender=sc.next();
airline="INDIAN AIRWAYS";
System.out.println("Enter the no of lagguage");
n=sc.nextInt();
checkIn_counter.insert_indian_airlines(gender,name,airline,n);
break;
case 4:
System.out.println("Enter your name");
name=sc.next();
System.out.println("Enter your gender");
gender=sc.next();
airline="INDIGO";
System.out.println("Enter the no of lagguage");
n=sc.nextInt();
checkIn_counter.insert_indigo(gender,name,airline,n);
case 7:break;
default:System.out.println("wrong choice");
}
}while(ch!=7);// end of do while loop for queries
try{
long finaltime=(time1+1)*5000;
Thread.sleep(finaltime);
}
catch (Exception e)
{
}
System.out.println("\n\tDo you want to continue: (Y/N)");
choice=sc.next().charAt(0);
}while(choice == 'y' || choice == 'Y');
//end of do while loop for input
}//end of main function
}// end of main class
