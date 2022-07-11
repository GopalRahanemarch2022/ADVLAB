package com.cdac.info;

import java.time.LocalDate;
import java.util.List;

import com.cdac.dao.AlbumSongDao;
import com.cdac.dao.GenericDao;
import com.cdac.entity.Album;
import com.cdac.entity.Song;

public class AlbumSongExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericDao genericDao = new GenericDao();

//		Album album = new Album();
//		album.setName("Hits of 2022");
//		album.setReleaseDate(LocalDate.of(2022, 12, 27));
//		album.setCopyrightString("Amazon Music");
//		
//		genericDao.save(album);

//		Album album2 = (Album)genericDao.fetchById(Album.class, 1);
//		Song song = new Song();
//		song.setTitle("GHI");
//		song.setArtist("Beyounce");
//		song.setDuration(4.35);
//		song.setAlbum(album2);
//		genericDao.save(song);

//		Album album2 = (Album)genericDao.fetchById(Album.class, 2);
//		Song song = new Song();
//		song.setTitle("VWX");
//		song.setArtist("Jonas Brothers");
//		song.setDuration(3.34);
//		song.setAlbum(album2);
//		genericDao.save(song);

//		AlbumSongDao albumSongDao = new AlbumSongDao();
//		List<Song> list = albumSongDao.fetchSongsSungBy("Taylor Swift");
//		for(Song song: list)
//			System.out.println(song.getTitle() + " " + song.getDuration());

//		albumSongDao.delete(Song.class,8);

		// understanding lazy/eager loading
//		Album album = (Album) genericDao.fetchById(Album.class, 1);
//		System.out.println(album.getName() + " " + album.getCopyrightString() + " " + album.getReleaseDate());
//		List<Song> songs = album.getSongs();
//		for (Song song : songs)
//			System.out.println(song.getTitle() + " " + song.getArtist() + " " + song.getDuration());

		Song song = (Song)genericDao.fetchById(Song.class,3);
		System.out.println(song.getTitle() + " " + song.getArtist() + " " + song.getDuration());
		Album album = song.getAlbum();
		System.out.println(album.getName() + " " + album.getCopyrightString() + " " + album.getReleaseDate());
	}

}
