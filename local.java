import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class local {

	public static void main(String[] args) throws IOException {
		File folder = new File("input"); //create the file
		File[] listfile = folder.listFiles();
		for(int a=0;a<listfile.length;a++){
				Scanner sc = new Scanner(listfile[a]);//new scan
				int size = sc.nextInt();//read total coordinate
				int[][] num = new int[size][2];
				float[] h  = new float[size];//new horizontal array	
				float[] v = new float[size];//new vertical array
				int count =0;
				int number =0;
				
				for (int i=0;i<size;i++){//run loop to store all the coorinate to num array
					num[i][0]=sc.nextInt();//put vertical coordinate to num[i][0] array
					num[i][1]=sc.nextInt();//put horizontal coordinate to num[i][1] array
					if(sc.hasNextLine()){
						sc.nextLine();//scan next line
						}
				}
				for(int i=0;i<size-1;i++){//run loop to create all of vertical line
					v[i]=(float) (num[i][0]+0.5);//create vertical line in position of vertical of point+0.5
				}
				for(int i=0;i<size-1;i++){//
					for(int j=i+1;j<size-1;j++){
						if(v[i] !=0 && v[j] !=0 ){// select two vertical lines
							float h1 = (num[i][1]+num[i+1][1])/2;// create a new horizontal line
							if(h1%1==0){
								h1 = (float) (h1+0.5);
							}
							if((num[j][1]<h1 && h1<num[j+1][1])||(num[j+1][1]<h1 && h1<num[j][1])){// first case, check if new line separate the point related to two horizontal lines
								if((num[i][1]<h1 && h1<num[j+1][1])||(num[j+1][1]<h1 && h1<num[i][1])){
								    
									h[count]=h1;// add the new line in to the list
									count++;
									v[i]=0; //remove two lines
									v[j]=0;
								}
							}
							else{ //second case
								h1 = (num[j][1]+num[j+1][1])/2;
								if(h1%1==0){
									h1 = (float) (h1+0.5);
								}
								if((num[i][1]<h1 && h1<num[i+1][1])||(num[i+1][1]<h1 && h1<num[i][1])){
									if((num[i][1]<h1 && h1<num[j+1][1])||(num[j+1][1]<h1 && h1<num[i][1])){
										h[count]=h1;
										count++;
										v[i]=0;
										v[j]=0;
									}
								}
								else{// if the new line fail to separate the coordinates
									continue;
								}
							}
						}	
					}
				}
				for(int i=0;i<size-1;i++){ //remove the duplicate lines
					for(int j=i+1;j<size-1;j++){
						if(h[i]==h[j]){
							h[i]=0;
						}
					}
				}
				for(int i=0;i<size-1;i++){ //count the total lines
					if(v[i] != 0){
						number++;
					}
				}
				for(int i=0;i<size-1;i++){
					if(h[i] != 0){
						number++;
					}
				}
				String fileout = "local_solution"+listfile[a].getName().charAt(8)+listfile[a].getName().charAt(9)+".txt"; //write the result to files
				File dicfile = new File("output_local");
				File actfile = new File(dicfile,fileout);
				FileWriter file =new FileWriter(actfile);  //  create FileWriter
				BufferedWriter writer = new BufferedWriter(file);  // create BufferedWriter
				writer.write(number+"");
				writer.newLine();
				for(int i=0;i<size-1;i++){
					if(v[i] != 0){
						writer.write("v "+v[i]);
						writer.newLine();
					}
				}
				for(int i=0;i<size-1;i++){
					if(h[i] != 0){
						writer.write("h "+h[i]);
						writer.newLine();
					}
				}
				writer.close();
				file.close();
		}
	}}


