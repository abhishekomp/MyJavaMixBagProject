package mftkgmcolt;

import mftkgmcolt.MFTCOLTKGM;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Disabled until I have a mft server to test against")
public class MFTCOLTKGM_Test {

    @Test
    @Disabled("Disabled until I have a mft server to test against")
    void test_send_sample_file() {
        MFTCOLTKGM mftcoltkgm = new MFTCOLTKGM();
        mftcoltkgm.uploadFile("cdt202115102.dat");
        mftcoltkgm.uploadFile("cdt202115102-Valid.dat");
        //assertThat(actual).isEqualTo(expected);
    }

    @Test
    void test_COLT_reads_downloadFolder() {
        MFTCOLTKGM mftcoltkgm = new MFTCOLTKGM();
        mftcoltkgm.coltReadsDownloadFolder();
        //assertThat(actual).isEqualTo(expected);
    }































    @Test
    void test_COLT_uploads_file_to_MFT() {
        MFTCOLTKGM mftcoltkgm = new MFTCOLTKGM();
        mftcoltkgm.uploadFile("cdt202115102.dat");
        //assertThat(actual).isEqualTo(expected);
    }


    @Test
    void test_COLT_downloads_file_from_MFT() {
        MFTCOLTKGM mftcoltkgm = new MFTCOLTKGM();
        mftcoltkgm.downloadFile("cdt200515102.dat");
        //assertThat(actual).isEqualTo(expected);
    }

    @Test
    void test_COLT_reads_Download_folder_in_MFT() {
        MFTCOLTKGM mftcoltkgm = new MFTCOLTKGM();
        mftcoltkgm.coltReadsDownloadFolder();
        //assertThat(actual).isEqualTo(expected);
    }

    @Test
    void test_COLT_delete_file_in_MFT() {
        MFTCOLTKGM mftcoltkgm = new MFTCOLTKGM();
        mftcoltkgm.coltDeleteFileFromDownloadFolder("SWEIITCOLISCOLTRS02_DWN", "cdt200515102.dat");
        //assertThat(actual).isEqualTo(expected);
    }

}
