//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Song
// Course:   CS 300 Spring 2022
//
// Author:   August Bambenek
// Email:    abambenek@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         NONE
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class models a song
 * 
 * @author August Bambenek
 */
public class Song {
  private String songName; // name or title of the song
  private String artist; // artist of the song
  private String duration; // duration of the song
  
  /**
   * Creates a new Song given the song name, the name of the artist, and the duration of the song
   * 
   * @param songName - title of the song
   * @param artist - name of the artist who performed this song
   * @param duration - duration of the song in the format mm:ss
   * @throws IllegalArgumentException with a descriptive error message if either of songName, or 
   * artist, or duration is null or is blank, or if the duration is not formatted as mm:ss where 
   * both mm and ss are in the 0 .. 59 range.
   */
  public Song(String songName, String artist, String duration) {
    if (songName == null || artist == null || duration == null || songName.isBlank() || 
        artist.isBlank() || duration.isBlank()) {
      throw new IllegalArgumentException("ERROR: an argument was null or blank");
    }
    
    if (!duration.contains(":")) {
      throw new IllegalArgumentException("ERROR: duration not formatted correctly");
    }
    else {
      try {
        int min = Integer.parseInt(duration.trim().substring(0, duration.indexOf(':')));
        int sec = Integer.parseInt(duration.trim().substring(duration.indexOf(':') + 1, 
            duration.length()));
        if (min < 0 || min > 59 || sec < 0 || sec > 59) {
          throw new IllegalArgumentException("ERROR: duration not formatted correctly");
        }
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException("ERROR: duration not formatted correctly");
      }
    }
    this.songName = songName;
    this.artist = artist;
    this.duration = duration;
  }
  
  /**
   * Gets the title or name of this song
   * 
   * @return the title or name of this song
   */
  public String getSongName() {
    return this.songName;
  }
  
  /**
   * Gets the name of the artist who performed this song
   * 
   * @return the artist who performed this song
   */
  public String getArtist() {
    return this.artist;
  }
  
  /**
   * Gets the duration of this song
   * 
   * @return the duration
   */
  public String getDuration() {
    return this.duration;
  }
  
  /**
   * Returns a string representation of this song. This string should be formatted as follows. 
   * "songName---artist---duration" where songName is the title of the song, artist is the name of 
   * the artist, and duration is the duration of the song.
   * 
   * @return a string representation of this song.
   */
  @Override
  public String toString() {
    return songName + "---" + artist + "---" + duration;
  }
  
  /**
   * Returns true when this song's name and artist strings equals to the other song's name and 
   * artist strings, and false otherwise. Note that this method takes an Object rather than a Song 
   * argument, so that it Overrides Object.equals(Object). If an object that is not an instance of 
   * Song is ever passed to this method, it should return false.
   * 
   * @param other - Song object to compare this object to
   * @return true when the this song has matching name and artist with respect to another song 
   * (case insensitive comparison)
   */
  @Override
  public boolean equals(java.lang.Object other) {
    if (other instanceof Song) {
      Song otherSong = (Song)other;
      if (this.songName.equals(otherSong.getSongName()) && 
          this.artist.equals(otherSong.getArtist())) {
        return true;
      }
    }
    return false;
  }
}
