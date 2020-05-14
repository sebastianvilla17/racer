package thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import model.Race;

public class RaceThread extends Thread {

	private Race race;
	private String structure;
	private String algorithm;
	private String mode;
	private long number;
	private long seed;
	private long time;

	public RaceThread(Race race, String structure, String algorithm, String mode, long number, long seed) {

		this.race = race;
		this.algorithm = algorithm;
		this.mode = mode;
		this.number = number;
		this.seed = seed;
		this.structure = structure;
		this.time = -1;
	}
	
	@Override
	public void run() {

		try
		{
			Random rd = new Random(seed);
			long start = 0;
			long end =  0;
			long i=0;
	
			switch(structure)
			{
				case "AL":
					switch (algorithm) {
						case "Add":
							start = System.currentTimeMillis();
							i = 0;
							while (i < number) {
								race.addArrayList(rd.nextLong());
								i++;
							}
							end = System.currentTimeMillis();
							break;
			
						case "Search":
							switch (mode) {
								case "Iterative":
									i = 0;
									while (i < number) {
										race.addArrayList(rd.nextLong());
										i++;
									}
									
									start = System.currentTimeMillis();
									i = 0;
									while (i < number) {
										race.searchArrayListI(rd.nextLong());
										i++;
									}						
									end = System.currentTimeMillis();
									break;
			
								case "Recursive":
									i = 0;
									while (i < number) {
										race.addArrayList(rd.nextLong());
										i++;
									}
									
									start = System.currentTimeMillis();
									i = 0;
									while (i < number) {
										race.searchArrayListR(rd.nextLong());
										i++;
									}						
									end = System.currentTimeMillis();
									break;
								}
							break;
	
						case "Delete":
							switch (mode) {
								case "Iterative":
									i = 0;
									while (i < number) {
										race.addArrayList(rd.nextLong());
										i++;
									}
									
									start = System.currentTimeMillis();
									i = 0;
									while (i < number) {
										race.deleteArrayListI(rd.nextLong());
										i++;
									}						
									end = System.currentTimeMillis();
									break;
			
								case "Recursive":
									i = 0;
									while (i < number) {
										race.addArrayList(rd.nextLong());
										i++;
									}
									
									start = System.currentTimeMillis();
									i = 0;
									while (i < number) {
										race.deleteArrayListR(rd.nextLong());
										i++;
									}						
									end = System.currentTimeMillis();
									break;
							}
						}
					break;
				case "ABB":
					switch (algorithm) {
						case "Add":
							switch (mode) {
								case "Iterative":
									start = System.currentTimeMillis();
									i = 0;
									while (i < number) {
										race.addABBI(rd.nextLong());
										i++;
									}
									end = System.currentTimeMillis();
									break;
								case "Recursive":
									start = System.currentTimeMillis();
									i = 0;
									while (i < number) {
										race.addABBR(rd.nextLong());
										i++;
									}
									end = System.currentTimeMillis();
									break;
							}
							break;
						case "Search":
							switch (mode) {
								case "Iterative":
									i = 0;
									while (i < number) {
										race.addABBR(rd.nextLong());
										i++;
									}
									
									start = System.currentTimeMillis();
									i = 0;
									while (i < number) {
										race.searchABBI(rd.nextLong());
										i++;
									}						
									end = System.currentTimeMillis();
									break;
			
								case "Recursive":
									i = 0;
									while (i < number) {
										race.addABBR(rd.nextLong());
										i++;
									}
									
									start = System.currentTimeMillis();
									i = 0;
									while (i < number) {
										race.searchABBR(rd.nextLong());
										i++;
									}						
									end = System.currentTimeMillis();
									break;
								}
							break;
						case "Delete":
							switch (mode) {
								case "Iterative":
									i = 0;
									while (i < number) {
										race.addABBR(rd.nextLong());
										i++;
									}
									
									start = System.currentTimeMillis();
									i = 0;
									while (i < number) {
										race.deleteABBI(rd.nextLong());
										i++;
									}						
									end = System.currentTimeMillis();
									break;
			
								case "Recursive":
									i = 0;
									while (i < number) {
										race.addABBR(rd.nextLong());
										i++;
									}
									
									start = System.currentTimeMillis();
									i = 0;
									while (i < number) {
										race.deleteABBR(rd.nextLong());
										i++;
									}						
									end = System.currentTimeMillis();
									break;
							}
						}
					break;
				case "LL":
					switch (algorithm) {
						case "Add":
							switch (mode) {
								case "Iterative":
									start = System.currentTimeMillis();
									i = 0;
									while (i < number) {
										race.addLinkedListI(rd.nextLong());
										i++;
									}
									end = System.currentTimeMillis();
									break;
								case "Recursive":
									start = System.currentTimeMillis();
									i = 0;
									while (i < number) {
										race.addLinkedListR(rd.nextLong());
										i++;
									}
									end = System.currentTimeMillis();
									break;
							}
							break;
						case "Search":
							switch (mode) {
								case "Iterative":
									i = 0;
									while (i < number) {
										race.addLinkedListI(rd.nextLong());
										i++;
									}
									
									start = System.currentTimeMillis();
									i = 0;
									while (i < number) {
										race.searchLinkedListI(rd.nextLong());
										i++;
									}						
									end = System.currentTimeMillis();
									break;
			
								case "Recursive":
									i = 0;
									while (i < number) {
										race.addLinkedListI(rd.nextLong());
										i++;
									}
									
									start = System.currentTimeMillis();
									i = 0;
									while (i < number) {
										race.SearchLinkedListR(rd.nextLong());
										i++;
									}						
									end = System.currentTimeMillis();
									break;
								}
							break;
	
						case "Delete":
							switch (mode) {
								case "Iterative":
									i = 0;
									while (i < number) {
										race.addLinkedListI(rd.nextLong());
										i++;
									}
									
									start = System.currentTimeMillis();
									i = 0;
									while (i < number) {
										race.deleteLinkedListI(rd.nextLong());
										i++;
									}						
									end = System.currentTimeMillis();
									break;
			
								case "Recursive":
									i = 0;
									while (i < number) {
										race.addLinkedListI(rd.nextLong());
										i++;
									}
									
									start = System.currentTimeMillis();
									i = 0;
									while (i < number) {
										race.deleteLinkedListR(rd.nextLong());
										i++;
									}						
									end = System.currentTimeMillis();
									break;
							}
						}
					break;
			}
	
			time= end-start;
		}
		catch(Exception ex)
		{
			System.out.println("Excepcion Run: "+ex.getMessage());
			time = 0;
		}
	}
	
	public String getTime() {
		
		String timeFinal = "-1";
		
		if(time != -1) 
		{
			SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
			Date resultdate = new Date(time);
			timeFinal = sdf.format(resultdate);
		}
		return timeFinal;

	}

}
