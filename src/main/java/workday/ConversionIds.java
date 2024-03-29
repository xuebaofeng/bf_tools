package workday;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConversionIds {

    public static void main(String[] args) {
        String i = "apply_xform, 7405.2863, 7405.2910, 7405.3061, 7405.3088, 7405.3168, 7405.3208, 7405.3208_updss, 7405.3208_updss_verify, 7405.3215, 7405.3358, 7405.3358_verify, 7405.3360, 7405.3360_verify, 7405.3362, 7405.3362_verify, 7405.3363, 7405.3363_verify, 7405.3365, 7405.3365_verify, 7405.3372, 7405.3372_verify, 7405.3373, 7405.3373_verify, 7405.3374, 7405.3374_verify, 7405.3375, 7405.3375_verify, 7405.3378, 7405.3378_verify, 7405.3398, 7405.3398_updss, 7405.3398_updss_verify, 7405.3399, 7405.3399_updss, 7405.3399_updss_verify, 7405.3576_verify, 7405.3660, 7405.3693, 7405.3697, 7405.3754_dropcount, 7405.3780_verify, 7405.3799, 7405.3809, 7405.3854, 7405.3897, 7405.3898, 7405.3934, 7405.3935, 7405.3943, 7405.3953_dropcount, 7405.3960, 7405.3967_verify, 7405.3976, 7405.3978, 7405.3988_verify, 7405.3991, agg_data_catchup, apply_xform, appss_verify, job_launcher, purge_del_su_v2, ref_count_repair, ref_idx, refmd_rpt, stack_verifier, 7405.306, 7405.307, 7405.408_dropcount, 7405.408_verify, 7405.1132, 7405.1756, 7405.1871, 7405.2075, 7405.2272_verify, 7405.2273_verify, 7405.2863, 7405.2903, 7405.2910, 7405.2982, 7405.3061, 7405.3072, 7405.3088, 7405.3168, 7405.3208, 7405.3208_updss, 7405.3208_updss_verify, 7405.3215, 7405.3321, 7405.3358, 7405.3358_verify, 7405.3360, 7405.3360_verify, 7405.3362, 7405.3362_verify, 7405.3363, 7405.3363_verify, 7405.3365, 7405.3365_verify, 7405.3372, 7405.3372_verify, 7405.3373, 7405.3373_verify, 7405.3374, 7405.3374_verify, 7405.3375, 7405.3375_verify, 7405.3378, 7405.3378_verify, 7405.3398, 7405.3398_updss, 7405.3398_updss_verify, 7405.3399, 7405.3399_updss, 7405.3399_updss_verify, 7405.3508, 7405.3512_verify, 7405.3513_verify, 7405.3576, 7405.3576_verify, 7405.3660, 7405.3673, 7405.3674, 7405.3679, 7405.3693, 7405.3697, 7405.3754_dropcount, 7405.3754_verify, 7405.3767, 7405.3780, 7405.3780_verify, 7405.3799, 7405.3809, 7405.3815, 7405.3845, 7405.3846, 7405.3851, 7405.3854, 7405.3859, 7405.3868, 7405.3879, 7405.3881, 7405.3885, 7405.3890, 7405.3892, 7405.3895, 7405.3897, 7405.3898, 7405.3903, 7405.3904, 7405.3924, 7405.3934, 7405.3935, 7405.3939, 7405.3940, 7405.3943, 7405.3948, 7405.3953_dropcount, 7405.3953_verify, 7405.3956, 7405.3957, 7405.3960, 7405.3961, 7405.3962, 7405.3963, 7405.3965, 7405.3967, 7405.3967_verify, 7405.3973, 7405.3976, 7405.3978, 7405.3980, 7405.3981, 7405.3982, 7405.3984, 7405.3986, 7405.3987, 7405.3988, 7405.3988_verify, 7405.3991, 7405.3995, 7405.3996_dropcount, 7405.3996_verify, 7405.3997, 7405.3998, 7405.3999";
        List<String> list = Arrays.stream(i.split(" ")).distinct().sorted().collect(Collectors.toList());
        for (String s : list) {
            System.out.print(s);
        }
    }

}


class Solution {
    public int romanToInt(String s) {
        int ans = 0;
        char last = ' ';
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'I':
                    ans += 1;
                    break;
                case 'V':
                    if (last == 'I') ans -= 1;
                    ans += 5;
                    break;
                case 'X':
                    if (last == 'I') ans -= 1;
                    ans += 10;
                    break;
                case 'L':
                    if (last == 'X') ans -= 10;
                    ans += 50;
                    break;
                case 'C':
                    if (last == 'C') ans -= 10;
                    ans += 100;
                    break;

                case 'D':
                    if (last == 'C') ans -= 100;
                    ans += 500;
                    break;
                case 'M':
                    if (last == 'C') ans -= 100;
                    ans += 1000;
                    break;
            }
            last = c;
        }

        return ans;
    }
}