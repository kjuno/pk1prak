import java.util.Comparator;

public class TitelSortierer implements Comparator<Medium>{

	@Override
	public int compare(Medium o1, Medium o2) {
		// TODO Auto-generated method stub
		return o1.getTitel().compareTo(o2.getTitel());
	}
}
