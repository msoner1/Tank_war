package Map;

/**
 * @author : Mustafa Soner Aydn
 * @version : 1.0.0
 * @since : 11.11.2015
 *
 * Oyunun haritaları için oluşturulmuş soyut classtır.
 */
public abstract class Map {
    public static int[] cordinates_x;
    public static int[] cordinates_y;

    public abstract int[] get_map_cordinates_x();
    public abstract int[] get_map_cordinates_y();

}
