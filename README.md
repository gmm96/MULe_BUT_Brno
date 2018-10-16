# MULe Final Project

### MP3 metadata editor

Created by Guillermo Montes Martos and Norma Schulze Giménez in 2018 for MULe subject in FIT of Brno University of Technology.


### 1. Introduction

In the present document we have detailed the analysis and development of an **editor of metadata for audio files**. We will focus in one format to show the functionality of the editor. For this purpose, we will use Java as programming language and we will use one of its libraries. The audio format that has been chosen is *MP3*.


### 2. Utility of metadata

The tagging of audiovisual files is essential for cataloguing. The classification by folders and file names is insufficient for large collections since it only provides a single search criterion.

Through **tagging** it is possible to organize a collection by multiple criteria. It allows a faster and simpler search of the desired files.

**Metadata** is literally “data about data”. Metadata deals with the content structure and similarities of the data. The generation is an important aspect of multimedia database, because directly queering the data can be extremely difficult.


### 3. Implementation

We used the Java library [Mp3agic](https://github.com/mpatric/mp3agic) as the base of our editor data program. This library is used for reading mp3 files and reading/manipulating the *ID3 tags* (ID3v1 and ID3v2.2 through ID3v2.4).


### 4. Theoretical basis

#### ID

In this context, *ID3* is the metadata container most often used in conjunction with the MP audio file format. It allows information such as *title, artist, album, track number, and other information* about the file to be stored in the file itself and other tags depending on the version.

#### Historial review

**ID3 tags** emerge after the MP3 standard. As there was a need to catalogue sound files with basic textual information about their origin: author, title, etc. Eric Kemp, with the development of the "Studio3" program, introduced a solution to this problem in 1996.

Thus, he suggested the possibility of including metadata at the end of each MP3 file. Finally, this idea was implemented with great success among users, with the first version of ID3 being born.

Subsequently, Michael Mutschler, creator of MP3ext, suggested version 1.1 of ID3. Despite its success, there were complaints about some technical limitations of the format of the tags. Therefore, version 2 of this informal standard was developed.

#### The format

#### ID3 Version

This first specification is very simple. It consists of attaching a *block of fixed size of 128 bytes* to the end of the file in question. This block contains the following tags:

- A **header** that identifies the presence of the ID3 block and its version. Specifically, header consists of the TAG characters.
- **Title**: 30 characters.
- **Artist**: 30 characters.
- **Album**: 30 characters.
- **Year**: 4 characters.
- **One comment**: 30 characters.
- **Genre**: a character.

All tags use *ASCII characters*, except for the genre, which is a whole number stored in a single byte. The musical genre associated with each byte is predefined in the standard and includes definitions of 80 genres, numbered from 0 to 79. Certain reproduction programs have expanded the defined genres 
on their own (from number 80).

![Genre list](https://raw.githubusercontent.com/gmm96/MULe_BUT_Brno/master/img/Screenshot_20181016_201108.png "Genre list")

#### ID3 Version 1.1

One significant disadvantage of the previous version is that it is not possible to indicate the **track number** corresponding to the album to which the recording belongs. Version 1.1 simply *subtracts* the last two characters of the comment tag for this purpose.

To distinguish this version of the previous one, the character No. 29 must be a null character, followed by a whole number in byte format that stores the song number in the album. If character # 30 is null or if # 29 is not, the song number is assumed to be unspecified.

It is a simple solution and compatible with the previous version. This includes software compatibility.


#### ID3 Version 2.0

Although ID3 version 1.x is sufficient in many cases, it presents some serious problems:

- The **length** of the tag is insufficient for some recordings.
- The use of ASCII characters prevents their use with non-western languages.
- The set of tags is **insufficient**. For example, in some recordings it is necessary to distinguish the author from the interpreter.
- It is not possible to include **new tags** that are not predefined, depending on the needs of each user. For example, the equalization preferences.

For this reason, version 2 of ID3 appears. The technical details are more complex than in previous versions. The most significant differences are the following:

- It uses **Unicode characters**, so it is open to any language.
- The tags are placed at the beginning of the file, not at the end. This facilitates Internet broadcasting via streaming, since you do not have to wait for the entire file to download to know the tags.
- The tags can have any length. There are no restrictions.
- It is possible to include images, not just text. For example, the *album art*.
- Supports **tags defined by the user**.
- More than 35 standard tags have been predefined.
- The lyrics of the song can be stored under the Lyrics3 frame in the TagID3, just like the album cover.
- The tags can be encrypted.


### 5. Technical details

We decide to merge the GUI and the logical part of the system, having knowledge of that is not the best programming practice. We took this decision for scheduling troubles.

First of all, let’s describe the main functions of the application:

- Open and **display MP3 Metadata**.
    o FileName
    o Track
    o Artist
    o Title
    o Album
    o Year
    o Genre
    o Comments
    o Composer
    o Publisher
    o Original Artist
    o Album Artist
    o Copyright
    o URL
    o Encoder
    o Bitrate
    o Sample rate
- **Edit metadata** and **save** MP3 files.
- Display, modify and export *album cover*. JPEG and PNG only compatible.

As we said previously, we used the Java library *Mp3agic* as the base of our editor data program. The thing is, that we realize that the library doesn’t allow us to save a file with the same filename. To solve this situation we designed a *workaround*, saving the file with a random name, deleting the old one and renaming the new file to the old name (done by saveMP3() method).

We always use the **ID3v2 tags** instead of ID3v1, because the v2 gives much more information and has more utility, meanwhile we are too limited with only 6 tags and limited value of characters per tag at v1. If the MP3 doesn’t have 
ID3v2 and we have an ID3v1 tag, we get this data and we set it into ID3v2 tag. Otherwise, a new empty ID3v2 tag is created.

As we mentioned before we can display and modify the album image. For this purpose, we need to create some auxiliary methods to convert the Java image to *binary format*. This is happening because the MP3agic library only supports array of bits for storing the album cover.

Finally, for **compiling and executing** the program you can use *ant*, a Java library and command-line tool whose mission is to drive processes described in build files as targets and extension points dependent upon each other. Run next commands in project root directory:

        $ ant
        $ java -jar dist/MULe.jar


#### Captures

![App at startup](https://raw.githubusercontent.com/gmm96/MULe_BUT_Brno/master/img/Screenshot_20181016_194250.png "App at startup")

![Opened MP3 file](https://raw.githubusercontent.com/gmm96/MULe_BUT_Brno/master/img/Screenshot_20181016_195251.png "Opened MP3 file")

![Saving file](https://raw.githubusercontent.com/gmm96/MULe_BUT_Brno/master/img/Screenshot_20181016_195513.png "Saving file")