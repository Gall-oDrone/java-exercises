package crackingTheCodeInterviewExs_OOD;

import java.util.Queue;
import java.util.Set;

public class IQ_7_3_Jukebox {

	public class Jukebox {
		private CDPlayer cdPlayer;
		private User user;
		private Set<CD> cdCollection;
		private SongSelector ts;
		
		public Jukebox(CDPlayer cdPlayer, User user, Set<CD> cdCollection, SongSelector ts) {
			super();
			this.cdPlayer = cdPlayer;
			this.user = user;
			this.cdCollection = cdCollection;
			this.ts = ts;
		}
		
		public Song getCurrentSong() { return ts.getCurrentSong(); }
		
		public void setUser(User u) { this.user = u; }
		
		public class CDPlayer {
			private Playlist p;
			private CD c;
			
			
			public CDPlayer() {
				super();
			}

			public CDPlayer(Playlist p, CD c) {
				super();
				this.p = p;
				this.c = c;
			}
			
			/* Play song */
			public void playSong(Song s) {}

			/* Getters and setters */
			public Playlist getP() {
				return p;
			}

			public void setP(Playlist p) {
				this.p = p;
			}

			public CD getC() {
				return c;
			}

			public void setC(CD c) {
				this.c = c;
			}
			
		}
		
		public class Playlist {
			private Song song;
			private Queue<Song> queue;
			
			public Playlist(Song song, Queue<Song> queue) {
				super();
				this.song = song;
				this.queue = queue;
			}
			
			public Song getNextSToPlay() {
				return queue.peek();
			}
			public void queueUpSong(Song s) {
				queue.add(s);
			}
		}
		
		public class CD { /* data for id, artist, songs, etc */}
		
		public class Song { /* data for id, CD (could be null), title, length, etc */ }
		
		public class User {
			private String name;
			public String getName() { return name; }
			public void setName(String name) { this.name = name; }
			public long getID() { return ID; }
			public void setID(long iD) { ID = iD; }
			private long ID;
			
			public User(String name, long iD) {
				super();
				this.name = name;
				ID = iD;
			}
			
			public User getUser() { return this; }
			public static User addUser(String name, long iD) {}
			
		}
	}
}
