package mftkgmcolt;

import mftkgmcolt.MFTKGMCOLT;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

@Disabled("Disabled until I have a mft server to test against")
public class MFTKGMCOLT_Test {


    @Test
    void test_KGM_uploads_a_file_to_MFT() {
        MFTKGMCOLT mftkgmcolt = new MFTKGMCOLT();
        mftkgmcolt.uploadFile("cdt200515102.dat");
        //assertThat(actual).isEqualTo(expected);
    }

    @Test
    void test_KGM_reads_Download_folder_in_MFT() {
        MFTKGMCOLT mftkgmcolt = new MFTKGMCOLT();
        mftkgmcolt.kgmReadsDownloadFolder();
        //assertThat(actual).isEqualTo(expected);
    }

    @Test
    void test_KGM_downloads_file() {
        MFTKGMCOLT mftkgmcolt = new MFTKGMCOLT();
        mftkgmcolt.downloadFile("cdt211011035127_101.dat");
        //assertThat(actual).isEqualTo(expected);
    }

    @Test
    void test_Read_and_display_content() {
        MFTKGMCOLT mftkgmcolt = new MFTKGMCOLT();
        mftkgmcolt.displayFileContent("cdt200515102.dat");
        //assertThat(actual).isEqualTo(expected);
    }
    @Test
    void test_downloadFiles_with_same_fileName() {
        MFTKGMCOLT mftkgmcolt = new MFTKGMCOLT();
        mftkgmcolt.downloadFile_with_sameFileName("");
        //assertThat(actual).isEqualTo(expected);
    }

    @Test
    void test_findFile_containing_particular_String() {
        MFTKGMCOLT mftkgmcolt = new MFTKGMCOLT();
        //mftkgmcolt.readFilesFromFolder("coltToKgm");
        String folderToSearch = "coltToKgm";
        String stringToSearch = "46722330114";
        String resutlFile = mftkgmcolt.findFileWithSpecificString(folderToSearch, stringToSearch);
        System.out.println(stringToSearch + " found in " + resutlFile);
        assertThat(resutlFile).isNotBlank();
    }

    @Test
    void test_process_DownloadedFile() {
        MFTKGMCOLT mftkgmcolt = new MFTKGMCOLT();
        mftkgmcolt.processDownloadedFile("cdt200515102.dat", "cdt200515102.dat");
        //assertThat(actual).isEqualTo(expected);
    }

    @Test
    void test_KGM_downloadsAndShowFileContent_file() {
        MFTKGMCOLT mftkgmcolt = new MFTKGMCOLT();
        mftkgmcolt.downloadAndReadFile("cdt210928101.dat");
        //assertThat(actual).isEqualTo(expected);
    }



    @Test
    void test_KGM_deletes_file() {
        MFTKGMCOLT mftkgmcolt = new MFTKGMCOLT();
        mftkgmcolt.kgmDeletesFromDownloadFolder("SWEIITCOLISCOLTRS04_DWN", "cdt200515102 - Copy.dat");
        //assertThat(actual).isEqualTo(expected);
    }

    @Test
    void test_KGM_reads_Download_folder_in_MFT_V2() {
        MFTKGMCOLT mftkgmcolt = new MFTKGMCOLT();
        mftkgmcolt.kgmReadsDownloadFolder("SWEIITCOLISCOLTRS04_DWN");
        //assertThat(actual).isEqualTo(expected);
    }

    @Test
    void test_KGM_reads_Upload_folder_in_MFT_V2() {
        MFTKGMCOLT mftkgmcolt = new MFTKGMCOLT();
        mftkgmcolt.kgmReadsDownloadFolder("SWEIITCOLISCOLTRS03_UPL");
        //assertThat(actual).isEqualTo(expected);
    }

    @Test
    void test_create_directory_inside_target() {
        String property = System.getProperty("user.dir");
        System.out.println("property=" + property);
        //assertThat(actual).isEqualTo(expected);
    }





}
