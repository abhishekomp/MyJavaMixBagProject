package mftkgmcolt;

import org.apache.commons.vfs2.*;

import java.io.BufferedReader;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MFTKGMCOLT {

    String username;
    String password;
    String remoteHost;
    String remoteDir_UPL;
    String remoteDir_DWN;
    FileSystemManager manager;
    public final String COLT_TO_KGM = "coltToKgm";
    public final String KGM_TO_COLT = "kgmToColt";
    public final int maxNumOfFilesToRead = 2;

    public MFTKGMCOLT() {
        //KGM sends the file to MFT
        this.username = "TUS-SWE-TRS-COL-01";
        this.password = ""; //ask for this
        this.remoteHost = "mfttestint.han.telia.se";
        this.remoteDir_UPL = "SWEIITCOLISCOLTRS03_UPL";
        this.remoteDir_DWN = "SWEIITCOLISCOLTRS04_DWN";

    }

    public void uploadFile(String filename) {
        try {
            manager = VFS.getManager();
            File f = new File(filename);
            System.out.println("File to upload f.getAbsolutePath() = " + f.getAbsolutePath());
            Path path = Paths.get(f.getAbsolutePath());

            FileObject local = manager.resolveFile(f.getAbsolutePath());
            FileObject remote = manager.resolveFile("sftp://" + username + ":" + password + "@" + remoteHost + "/" + remoteDir_UPL + "/" + f.getName());
            remote.copyFrom(local, Selectors.SELECT_SELF);

            local.close();
            remote.close();
            System.out.println("File sent through MFT OK");

        } catch (FileSystemException e) {
            e.printStackTrace();
        }
    }

    public void kgmReadsDownloadFolder_Old() {
        try {
            manager = VFS.getManager();

            System.out.println("KGM Reading Download folder: " + remoteDir_DWN);
            FileObject remote = manager.resolveFile("sftp://" + username + ":" + password + "@" + remoteHost + "/" + remoteDir_DWN + "/");
            FileObject[] children = remote.getChildren();
            for (int i = 0; i < children.length; i++) {
                System.out.println(children[i].getName().getBaseName());
            }
            remote.close();
            System.out.println("KGM read download folder in MFT: " + remoteDir_DWN);
        } catch (FileSystemException e) {
            e.printStackTrace();
        }
    }

    public List<String> kgmReadsDownloadFolder() {
        List<String> files = new ArrayList<>();
        try {
            manager = VFS.getManager();

            System.out.println("KGM Reading Download folder: " + remoteDir_DWN);
            FileObject remote = manager.resolveFile("sftp://" + username + ":" + password + "@" + remoteHost + "/" + remoteDir_DWN + "/");
            FileObject[] children = remote.getChildren();

            for (int i = 0; i < children.length; i++) {
                String fileName = children[i].getName().getBaseName();
                //System.out.println(fileName);
                files.add(fileName);
            }
            remote.close();
            if (files.size() > 0) {
                System.out.println("Files in : " + remoteDir_DWN + " are:");
                files.stream().forEach(System.out::println);
            } else
                System.out.println("No files found in : " + remoteDir_DWN);

        } catch (FileSystemException e) {
            e.printStackTrace();
        }
        return files;
    }

    public void kgmReadsDownloadFolder(String folderToRead) {
        try {
            manager = VFS.getManager();

            System.out.println("KGM Reading Download folder: " + folderToRead);
            FileObject remote = manager.resolveFile("sftp://" + username + ":" + password + "@" + remoteHost + "/" + folderToRead + "/");
            FileObject[] children = remote.getChildren();
            for (int i = 0; i < children.length; i++) {
                System.out.println(children[i].getName().getBaseName());
            }
            remote.close();
            System.out.println("KGM read download folder in MFT: " + folderToRead);
        } catch (FileSystemException e) {
            e.printStackTrace();
        }
    }

    public void kgmDeletesFromDownloadFolder(String folderName, String fileToDelete) {
        try {
            manager = VFS.getManager();

            File f = new File(fileToDelete);
            FileObject remote = manager.resolveFile("sftp://" + username + ":" + password + "@" + remoteHost + "/" + folderName + "/" + f.getName());
            int delete = remote.delete(Selectors.SELECT_SELF);
            System.out.println("delete=" + delete);
        } catch (FileSystemException e) {
            e.printStackTrace();
        }
    }

    //KGM downloads the file from MFT(files sent by COLT)
    //remoteFile: name of the remote file to download
    //the downloaded file is stored in target folder
    public void downloadFile(String remoteFile) {
        try {
            manager = VFS.getManager();
            File remotefileObj = new File(remoteFile);
            //System.out.println("File to download = " + remotefileObj.getAbsolutePath());
            System.out.println("File to download = " + remoteFile);
            String localDir = "target/";
            FileObject local = manager.resolveFile(
                    System.getProperty("user.dir") + "/" + localDir + "FileFromCOLT.txt");
            FileObject remote = manager.resolveFile("sftp://" + username + ":" + password + "@" + remoteHost + "/" + remoteDir_DWN + "/" + remotefileObj.getName());

            local.copyFrom(remote, Selectors.SELECT_SELF);

            local.close();
            remote.close();
            System.out.println("File received through MFT OK");
        } catch (FileSystemException e) {
            e.printStackTrace();
        }
    }

    public void downloadFile_with_sameFileName(String remoteFile) {
        try {
            String path = System.getProperty("user.dir") + File.separator + "target" + File.separator + COLT_TO_KGM;
            boolean createFlg = createDir(path);
            path = System.getProperty("user.dir") + File.separator + "target" + File.separator + KGM_TO_COLT;
            createFlg = createDir(path);

            manager = VFS.getManager();

            FileObject local = manager.resolveFile(
                    System.getProperty("user.dir") + File.separator + "target" + File.separator + COLT_TO_KGM);
            FileObject remote = manager.resolveFile("sftp://" + username + ":" + password + "@" + remoteHost + "/" + remoteDir_DWN + "/");
            FileObject[] children = remote.getChildren();
            int numOfFilesAvailable = children.length;
            System.out.println("Number of files: " + numOfFilesAvailable);
            String availableFile = null;
            if(numOfFilesAvailable > 0) {
                System.out.println("File(s) present are:");
            }
            else {
                System.out.println("No files present in " + COLT_TO_KGM);
            }

            for(int i = 0; i < numOfFilesAvailable; i++) {
                availableFile = children[i].getName().getBaseName();
                System.out.println(availableFile);
                local = manager.resolveFile(
                        System.getProperty("user.dir") + File.separator + "target" + File.separator + COLT_TO_KGM + File.separator + availableFile);
                remote = manager.resolveFile("sftp://" + username + ":" + password + "@" + remoteHost + "/" + remoteDir_DWN + "/" + availableFile);
                local.copyFrom(remote, Selectors.SELECT_SELF);
            }
            local.close();
            remote.close();
        } catch (FileSystemException e) {
            e.printStackTrace();
        }
    }

    /*  fileIn: Name of the file to process
    *   fileOut: Name of the output file after processing
     */
    public boolean processDownloadedFile(String fileIn, String fileOut) {
        boolean processFlg = false;
        FileReader file = null;
        BufferedReader fileStream = null;
        List<String> lines = new ArrayList<>();
        try {
            file = new FileReader("target" + File.separator + COLT_TO_KGM + File.separator + fileIn, StandardCharsets.ISO_8859_1);

            fileStream = new BufferedReader(file);
            String temp = null;
            while ((temp = fileStream.readLine()) != null) {
                System.out.println(temp);
                lines.add(temp);
            }
            List<String> updatedLines = new ArrayList<>();
            updatedLines.add(lines.get(0));
            for(int i = 1; i < lines.size() - 1; i++) {
                //code to fetch available ICCID
                String line = updateLine(lines.get(i), "88887777");
                updatedLines.add(line);
            }
            updatedLines.add(lines.get(lines.size()-1));

            //print all (for showing the result)
            System.out.println("****************KGM RESPONSE***********************");
            updatedLines.stream().forEach(System.out::println);

            //Write the output to a file
            writeUsingEncoding(updatedLines, fileOut);
            processFlg = true;
        } catch (FileNotFoundException e) {
            System.out.println("No file was found");
        } catch (IOException e) {
            System.out.println("There was a problem reading the file");
        } finally {
            try {
                fileStream.close();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return processFlg;
    }

    public String updateLine(String line, String iccId) {
        //add space characters
        String updatedLine = insertSpace(line, 78);
        updatedLine = insertIccId(updatedLine, iccId);
        updatedLine = insertSpace(updatedLine, 22);
        return updatedLine;
    }

    public String insertSpace(String line, int i) {
        StringBuilder str = new StringBuilder(line);
        for(int j = 0; j < i; j++) {
            str.append(' ');
        }
        return str.toString();
    }

    private String insertIccId(String s, String iccId) {
        StringBuilder str = new StringBuilder(s);
        StringBuilder appendStr = str.append(iccId);
        return appendStr.toString();
    }

    private void writeUsingEncoding(List<String> updatedLines, String UPLOAD_FILENAME) {
        Path path = Paths.get("target" + File.separator + KGM_TO_COLT + File.separator + UPLOAD_FILENAME);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.ISO_8859_1)) {
            for (String line : updatedLines) {
                writer.append(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> readFilesFromFolder(String folderToRead) {
        List<String> result = new ArrayList<>();
        try (Stream<Path> walk = Files.walk(Paths.get("target" + File.separator + folderToRead))) {
           result = walk.filter(Files::isRegularFile)
                    .map(x -> x.toString()).collect(Collectors.toList());

            //result.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    //WIP
    public String findFileWithSpecificString(String folder, String strToSearch) {
        List<String> fileList = readFilesFromFolder(folder);
        //fileList.forEach(System.out::println);  //Output: target\coltToKgm\cdt200515102.dat
        String resultFile = "";
        for(String filePath : fileList) {
            try (FileReader file = new FileReader(filePath, StandardCharsets.ISO_8859_1);
                 BufferedReader fileStream = new BufferedReader(file);
            ){
                String temp = null;
                while ((temp = fileStream.readLine()) != null) {
                    if (temp.contains(strToSearch)) {
                        //System.out.println(strToSearch + " found in " + filePath);
                        resultFile = filePath;
                        break;
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    return resultFile;
    }

    public boolean createDir(String dirPath) {
        boolean mkdirFlg = false;
        File directory = new File(dirPath);
        if (! directory.exists()){
            mkdirFlg = directory.mkdir();
        }
        return mkdirFlg;
    }

    //KGM downloads the file from MFT(files sent by COLT)
    //remoteFile: name of the remote file to download
    public void downloadAndReadFile(String remoteFile) {
        try {
            manager = VFS.getManager();
            File remotefileObj = new File(remoteFile);
            //System.out.println("File to download = " + remotefileObj.getAbsolutePath());
            System.out.println("File to download = " + remoteFile);
            String localDir = "target";
            String filePath = System.getProperty("user.dir") + File.separator + localDir + File.separator + "FileFromCOLT.txt";
            System.out.println("File to download will be placed at = " + filePath);

            FileObject local = manager.resolveFile(filePath);
            FileObject remote = manager.resolveFile("sftp://" + username + ":" + password + "@" + remoteHost + "/" + remoteDir_DWN + "/" + remotefileObj.getName());
            local.copyFrom(remote, Selectors.SELECT_SELF);
            local.close();
            remote.close();
            System.out.println("File received through MFT OK");
        } catch (FileSystemException e) {
            e.printStackTrace();
        }
    }

    public void displayFileContent(String fileIn) {
        FileReader file = null;
        BufferedReader fileStream = null;
        List<String> lines = new ArrayList<>();
        try {
            file = new FileReader("target" + File.separator + fileIn, StandardCharsets.ISO_8859_1);
            fileStream = new BufferedReader(file);
            String temp = null;
            while ((temp = fileStream.readLine()) != null) {
                System.out.println(temp);
                //lines.add(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
