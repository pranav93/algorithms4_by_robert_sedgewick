package E_2_5_10;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Version implements Comparable<Version> {
    int major;
    int minor;
    int patch;

    Version(String version) {
        String[] versionArr = version.split("\\.");
        this.major = Integer.parseInt(versionArr[0]);
        this.minor = Integer.parseInt(versionArr[1]);
        this.patch = Integer.parseInt(versionArr[2]);
    }

    public static void main(String[] args) {
        String s1 = StdIn.readString();
        Version v1 = new Version(s1);
        String s2 = StdIn.readString();
        Version v2 = new Version(s2);
        StdOut.println("v1.compareTo(v2) -> " + v1.compareTo(v2));
    }

    @Override
    public int compareTo(Version that) {
        // TODO Auto-generated method stub
        if (this.major > that.major) {
            return 1;
        } else if (this.major < that.major) {
            return -1;
        } else if (this.minor > that.minor) {
            return 1;
        } else if (this.minor < that.minor) {
            return -1;
        } else if (this.patch > that.patch) {
            return 1;
        } else if (this.patch < that.patch) {
            return -1;
        } else {
            return 0;
        }
    }
}