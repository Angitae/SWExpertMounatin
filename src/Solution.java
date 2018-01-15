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
	static int leng; // 등산로 최대 길이
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
					// 최대 높이 저장해주고...
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
	static int leng; // 등산로 최대 길이
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
					// 최대 높이 저장해주고...
				}
			}
			for(int e = 0; e < N; e++){
				for(int y = 0; y < N; y++){
					map2[e][y] = map[e][y];
				}
			}// map 복사해주고 
			enque(); // 큐에다가 최대 높이 지점들을 저장해주고 ...
			Point p;
			  while(!q.isEmpty()){ // 큐가 빌 때 까지 꺼내서 확인하고...
				  p =  q.peek();
				  x = p.x;
				  y = p.y;		 
				  for(int f=0; f <= k; f++){ //0~k만큼의 높이 다 깎아주고...
						for(int a= 0; a< N; a++){
							for(int b = 0; b < N; b++){
//								visit[a][b] = true; // 0,0지점부터 시작했으니까 true로 만들어주고.
//								if( visit[a][b] == true ){ // 방문했으면 깎자
									map[a][b] -= f;
//									visit[a][b] = false; // 다시 false 처리해주고 .
									dfs(x, y, 1); // 최대지점에 있던 거부터 탐색 ㄱㄱ
//									
//									
//									
									// 이 지점에다가 fina 다시 1로 처리해야 산을 깎을 때 다시 반영될듯???
//									
//									
//									
//									
									
									// 밑에 두 줄 임시로 주석처리 
//									 leng = Math.max(0, leng); // leng길이가 최대로 나온거 저장하고 .
//									 fina = Math.max(fina, leng); // 그거를 임시변수랑 비교해서 최대로 나온거 저장 

									
									
									init(); // 초기화 다시 시켜주고 
//								}
							}
						}
					} 
//				  dfs(x, y, 1); // Q에 들어 있는거에서 하나 빼서 돌리고 ...
				  // 여기에다가 깎은거 다시 초기화 해주고...
			  q.poll();	
			  // Q에 있는거 빼고 ( 하나씩 ) 
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
		leng = Math.max(0, leng); // leng길이가 최대로 나온거 저장하고 .
		 fina = Math.max(fina, leng); // 그거를 임시변수랑 비교해서 최대로 나온거 저장 
		
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
	}// 맵 초기화 해주기
	
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
   static int leng; // 등산로 최대 길이
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
               // 최대 높이 저장해주고...
            }
         }
         for(int e = 0; e < N; e++){
            for(int y = 0; y < N; y++){
               map2[e][y] = map[e][y];
            }
         }// map 복사해주고 
         enque(); // 큐에다가 최대 높이 지점들을 저장해주고 ...
         Point p;
           while(!q.isEmpty()){ // 큐가 빌 때 까지 꺼내서 확인하고...
              p =  q.peek();
              x = p.x;
              y = p.y;       
              for(int f=0; f <= k; f++){ //0~k만큼의 높이 다 깎아주고...
                  for(int a= 0; a< N; a++){
                     for(int b = 0; b < N; b++){
//                        visit[a][b] = true; // 0,0지점부터 시작했으니까 true로 만들어주고.
//                        if( visit[a][b] == true ){ // 방문했으면 깎자
                           map[a][b] -= f;
//                           visit[a][b] = false; // 다시 false 처리해주고 .
                           dfs(x, y, 1); // 최대지점에 있던 거부터 탐색 ㄱㄱ
                           
                           // 밑에 두 줄 임시로 주석처리 
//                            leng = Math.max(0, leng); // leng길이가 최대로 나온거 저장하고 .
//                            fina = Math.max(fina, leng); // 그거를 임시변수랑 비교해서 최대로 나온거 저장 

                           
                           
                           init(); // 초기화 다시 시켜주고 
//                        }
                     }
                  }
               } 
//              dfs(x, y, 1); // Q에 들어 있는거에서 하나 빼서 돌리고 ...
              // 여기에다가 깎은거 다시 초기화 해주고...
           q.poll();   
           // Q에 있는거 빼고 ( 하나씩 ) 
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
      leng = Math.max(0, leng); // leng길이가 최대로 나온거 저장하고 .
       fina = Math.max(fina, leng); // 그거를 임시변수랑 비교해서 최대로 나온거 저장 
      
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
   }// 맵 초기화 해주기
   
}