package Utils;

import DTOmodels.ItemDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Iterables.isEmpty;

@Slf4j
public class Utils {

    public static ItemDTO convertToMapToItem(List<Map<String, String>> data) {
        double price = Double.parseDouble(data.get(0).get("price"));
        return new ItemDTO(data.get(0).get("item"), price);
    }

    public static boolean isSortedAtoZ(List<ItemDTO> listOfStrings) {
        if (isEmpty(listOfStrings) || listOfStrings.size() == 1) {
            return true;
        }

        Iterator<ItemDTO> iter = listOfStrings.iterator();
        ItemDTO current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (previous.getName().compareTo(current.getName()) > 0) {
                System.out.println(previous.getName());
                System.out.println(current.getName());
                return false;
            }
            previous = current;
        }
        log.info("This list is ordered by name from A to Z");
        return true;
    }

    public static boolean isSortedZtoA(List<ItemDTO> listOfStrings) {
        if (isEmpty(listOfStrings) || listOfStrings.size() == 1) {
            return true;
        }

        Iterator<ItemDTO> iter = listOfStrings.iterator();
        ItemDTO current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (previous.getName().compareTo(current.getName()) < 0) {
                System.out.println(previous.getName());
                System.out.println(current.getName());
                log.info("This list is NOT ordered");
                return false;
            }
            previous = current;
        }
        log.info("This list is ordered by name from Z to A");
        return true;
    }

    public static boolean isSorted1to9(List<ItemDTO> listOfDoubles) {
        if (isEmpty(listOfDoubles) || listOfDoubles.size() == 1) {
            return true;
        }

        Iterator<ItemDTO> iter = listOfDoubles.iterator();
        ItemDTO current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (Double.compare(previous.getPrice(), current.getPrice()) > 0) {
                System.out.println(previous.getPrice());
                System.out.println(current.getPrice());
                log.info("This list is NOT ordered");
                return false;
            }
            previous = current;
        }
        log.info("This list is ordered by price from 1 to 9");
        return true;
    }

    public static boolean isSorted9to1(List<ItemDTO> listOfDoubles) {
        if (isEmpty(listOfDoubles) || listOfDoubles.size() == 1) {
            return true;
        }

        Iterator<ItemDTO> iter = listOfDoubles.iterator();
        ItemDTO current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (Double.compare(previous.getPrice(), current.getPrice()) < 0) {
                System.out.println(previous.getPrice());
                System.out.println(current.getPrice());
                log.info("This list is NOT ordered");
                return false;
            }
            previous = current;
        }
        log.info("This list is ordered by price from 9 to 1");
        return true;
    }
}
