/*import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	static int N;
	static int map[][];
	static int map2[][];
	static boolean visit[][];
	static Queue<Point> q = new LinkedList<Point>();
	static int tc;
	static int k;
	static int leng; // ���� �ִ� ����
	static int max;
	static int dx[] = {0, 1, 0 ,-1};
	static int dy[] = {-1, 0, 1, 0};
	static int x, y;
	static int dix, diy;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		for(int i =1; i<tc+1; i++){
			N= sc.nextInt();
			k = sc.nextInt();
			map = new int[N][N];
			visit = new boolean[N][N];
			for(int j = 0; j < N; j++){
				for(int w = 0; w < N; w++){
					map[j][w] = sc.nextInt();
					max = Math.max(max, map[j][w]);
					// �ִ� ���� �������ְ�...
				}
			}
			enque();
			dfs();
			leng = Math.max(0, leng);
			System.out.println("#"+i + " "+ leng);
		}
	}
	
	static void enque(){
		for(int i = 0; i < N; i++){
			for(int j =0; j < N; j++){
				if(map[i][j] == max){
					q.add(new Point(i,j));
				}
			}
		}
	}
	
	static void dfs(){
		Point p;
		  while(!q.isEmpty()){
			  p =  q.peek();
			  x = p.x;
			  y = p.y;		  
			  
			  for(int i =0; i < 4; i++){
			dix = x + dx[i];
			diy = y + dy[i];
			if(0 <= dix && dix < N && 0 <= diy && diy <N && map[dix][diy]< map[x][y] && visit[dix][diy] == false ){
				leng++;
				visit[dix][diy] = true;
			}
		}
		  q.poll();	
		  }
	}
}*/


/*
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	static int N;
	static int map[][];
	static int map2[][];
	static boolean visit[][];
	static Queue<Point> q = new LinkedList<Point>();
	static int tc;
	static int k;
	static int leng; // ���� �ִ� ����
	static int max;
	static int dx[] = {0, 1, 0 ,-1};
	static int dy[] = {-1, 0, 1, 0};
	static int x, y;
	static int dix, diy;
	static int fina;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		for(int i =1; i<tc+1; i++){
			N= sc.nextInt();
			k = sc.nextInt();
			map = new int[N][N];
			map2 = new int [N][N];
			visit = new boolean[N][N];
			for(int j = 0; j < N; j++){
				for(int w = 0; w < N; w++){
					map[j][w] = sc.nextInt();
					max = Math.max(max, map[j][w]);
					// �ִ� ���� �������ְ�...
				}
			}
			for(int e = 0; e < N; e++){
				for(int y = 0; y < N; y++){
					map2[e][y] = map[e][y];
				}
			}// map �������ְ� 
			enque(); // ť���ٰ� �ִ� ���� �������� �������ְ� ...
			Point p;
			  while(!q.isEmpty()){ // ť�� �� �� ���� ������ Ȯ���ϰ�...
				  p =  q.peek();
				  x = p.x;
				  y = p.y;		 
				  for(int f=0; f <= k; f++){ //0~k��ŭ�� ���� �� ����ְ�...
						for(int a= 0; a< N; a++){
							for(int b = 0; b < N; b++){
//								visit[a][b] = true; // 0,0�������� ���������ϱ� true�� ������ְ�.
//								if( visit[a][b] == true ){ // �湮������ ����
									map[a][b] -= f;
//									visit[a][b] = false; // �ٽ� false ó�����ְ� .
									dfs(x, y, 1); // �ִ������� �ִ� �ź��� Ž�� ����
//									
//									
//									
									// �� �������ٰ� fina �ٽ� 1�� ó���ؾ� ���� ���� �� �ٽ� �ݿ��ɵ�???
//									
//									
//									
//									
									
									// �ؿ� �� �� �ӽ÷� �ּ�ó�� 
//									 leng = Math.max(0, leng); // leng���̰� �ִ�� ���°� �����ϰ� .
//									 fina = Math.max(fina, leng); // �װŸ� �ӽú����� ���ؼ� �ִ�� ���°� ���� 

									
									
									init(); // �ʱ�ȭ �ٽ� �����ְ� 
//								}
							}
						}
					} 
//				  dfs(x, y, 1); // Q�� ��� �ִ°ſ��� �ϳ� ���� ������ ...
				  // ���⿡�ٰ� ������ �ٽ� �ʱ�ȭ ���ְ�...
			  q.poll();	
			  // Q�� �ִ°� ���� ( �ϳ��� ) 
//			  leng = Math.max(0, leng);
			  // 
			  }
			System.out.println("#"+i + " "+ fina);
			fina = 1;
		}
	}
	
	static void enque(){
		for(int i = 0; i < N; i++){
			for(int j =0; j < N; j++){
				if(map[i][j] == max){
					q.add(new Point(i,j));
//					q.offer(new Point(i,j));
				}
			}
		}
	}
	
	static void dfs(int x, int y, int cnt){
		if(visit[x][y] == false){
		visit[x][y]= true;
		}		
		leng = cnt;
		leng = Math.max(0, leng); // leng���̰� �ִ�� ���°� �����ϰ� .
		 fina = Math.max(fina, leng); // �װŸ� �ӽú����� ���ؼ� �ִ�� ���°� ���� 
		
		for(int i =0; i < 4; i++){
			dix = x + dx[i];
			diy = y + dy[i];
			if(0 <= dix && dix < N && 0 <= diy && diy < N && map[dix][diy]< map[x][y] && visit[dix][diy] == false ){
//				visit[dix][diy] = true;
				leng = cnt;
				dfs(dix, diy, cnt+1);
			}
		}
	}

	static void init(){  
		for(int i =0; i < N; i++){
			for(int j =0; j < N; j++){
				visit[i][j] = false;
				map[i][j] = map2[i][j];
			}
		}
	}// �� �ʱ�ȭ ���ֱ�
	
}*/


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
   int x, y;
   Point(int x, int y){
      this.x = x;
      this.y = y;
   }
}

public class Solution {
   static int N;
   static int map[][];
   static int map2[][];
   static boolean visit[][];
   static Queue<Point> q = new LinkedList<Point>();
   static int tc;
   static int k;
   static int leng; // ���� �ִ� ����
   static int max;
   static int dx[] = {0, 1, 0 ,-1};
   static int dy[] = {-1, 0, 1, 0};
   static int x, y;
   static int dix, diy;
   static int fina;
   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      tc = sc.nextInt();
      for(int i =1; i<tc+1; i++){
        max=0;
         N= sc.nextInt();
         k = sc.nextInt();
         map = new int[N][N];
         map2 = new int[N][N];
         visit = new boolean[N][N];
         for(int j = 0; j < N; j++){
            for(int w = 0; w < N; w++){
               map[j][w] = sc.nextInt();
               max = Math.max(max, map[j][w]);
               // �ִ� ���� �������ְ�...
            }
         }
         for(int e = 0; e < N; e++){
            for(int y = 0; y < N; y++){
               map2[e][y] = map[e][y];
            }
         }// map �������ְ� 
         enque(); // ť���ٰ� �ִ� ���� �������� �������ְ� ...
         Point p;
           while(!q.isEmpty()){ // ť�� �� �� ���� ������ Ȯ���ϰ�...
              p =  q.peek();
              x = p.x;
              y = p.y;       
              for(int f=0; f <= k; f++){ //0~k��ŭ�� ���� �� ����ְ�...
                  for(int a= 0; a< N; a++){
                     for(int b = 0; b < N; b++){
//                        visit[a][b] = true; // 0,0�������� ���������ϱ� true�� ������ְ�.
//                        if( visit[a][b] == true ){ // �湮������ ����
                           map[a][b] -= f;
//                           visit[a][b] = false; // �ٽ� false ó�����ְ� .
                           dfs(x, y, 1); // �ִ������� �ִ� �ź��� Ž�� ����
                           
                           // �ؿ� �� �� �ӽ÷� �ּ�ó�� 
//                            leng = Math.max(0, leng); // leng���̰� �ִ�� ���°� �����ϰ� .
//                            fina = Math.max(fina, leng); // �װŸ� �ӽú����� ���ؼ� �ִ�� ���°� ���� 

                           
                           
                           init(); // �ʱ�ȭ �ٽ� �����ְ� 
//                        }
                     }
                  }
               } 
//              dfs(x, y, 1); // Q�� ��� �ִ°ſ��� �ϳ� ���� ������ ...
              // ���⿡�ٰ� ������ �ٽ� �ʱ�ȭ ���ְ�...
           q.poll();   
           // Q�� �ִ°� ���� ( �ϳ��� ) 
//           leng = Math.max(0, leng);
           // 
           }
         System.out.println("#"+i + " "+ fina);
         fina = 1;
         leng=1;
      }
   }
   
   static void enque(){
      for(int i = 0; i < N; i++){
         for(int j =0; j < N; j++){
            if(map[i][j] == max){
               q.add(new Point(i,j));
//               q.offer(new Point(i,j));
            }
         }
      }
   }
   
   static void dfs(int x, int y, int cnt){
      if(visit[x][y] == false){
      visit[x][y]= true;
      leng = cnt;
      leng = Math.max(0, leng); // leng���̰� �ִ�� ���°� �����ϰ� .
       fina = Math.max(fina, leng); // �װŸ� �ӽú����� ���ؼ� �ִ�� ���°� ���� 
      
      for(int i =0; i < 4; i++){
         dix = x + dx[i];
         diy = y + dy[i];
         if(0 <= dix && dix < N && 0 <= diy && diy < N && map[dix][diy]< map[x][y] && visit[dix][diy] == false ){
//            visit[dix][diy] = true;
            //leng = cnt;
            dfs(dix, diy, cnt+1);
            }
         }
      visit[x][y]=false;
      }
   }

   static void init(){  
      for(int i =0; i < N; i++){
         for(int j =0; j < N; j++){
            visit[i][j] = false;
            map[i][j] = map2[i][j];
         }
      }
   }// �� �ʱ�ȭ ���ֱ�
   
}