/*
 * @author kumar
 * @author lohia
 * @author pant
 * @author sukrit
 */

import java.util.ArrayList;
import java.util.Vector;

public class Utility
{
    public static void printAttributes(Main obj)
    {
        obj.jTextArea1.setText(null);
        for(String attr : obj.attribute)
        {
            obj.jTextArea1.append(attr + "\n");
        }
    }
    
    public static void printDependencies(Main obj)
    {
        Utility.updateDependency(obj);
        obj.jTextArea2.setText(null);
        for(Vector<ArrayList<String>> dep : obj.dependency)
        {
            boolean newline = true;
            for(String leftattr : dep.get(0))
            {
                if(newline)
                {
                    obj.jTextArea2.append(leftattr);
                    newline = false;
                }
                else
                {
                    obj.jTextArea2.append(", " + leftattr);
                }
            }
            obj.jTextArea2.append(" --> " + dep.get(1).get(0) + "\n");
        }
    }
    
    public static void printKeys(Main obj)
    {
        Utility.getClosureAll(obj);
        Utility.getKeys(obj);
        obj.jTextArea4.setText(null);
        for(ArrayList<String> key : obj.keys)
        {
            obj.jTextArea4.append(key.toString() + "\n");
        }
    }
    
    public static void printNormalForm(Main obj)
    {
        Utility.getNormalFormAll(obj);
        int min = 4;
        for(Vector<ArrayList<String>> dep : obj.dependency)
        {
            int x = Integer.parseInt(dep.get(2).get(0));
            if(x < min)
            {
                min = x;
            }
        }
        switch(min)
        {
            case 1:
                obj.jLabel7.setText("1st");
                break;
            case 2:
                obj.jLabel7.setText("2nd");
                break;
            case 3:
                obj.jLabel7.setText("3rd");
                break;
            case 4:
                obj.jLabel7.setText("BCNF");
                break;
        }
    }
    
    public static void printDecomposition(Main obj)
    {
        obj.jTextArea3.setText(null);
        int min = 4;
        for(Vector<ArrayList<String>> dep : obj.dependency)
        {
            int x = Integer.parseInt(dep.get(2).get(0));
            if(x < min)
            {
                min = x;
            }
        }
        switch(min)
        {
            case 1:
                Utility.decompose(obj, "1");
                break;
            case 2:
                Utility.decompose(obj, "2");
                break;
            case 3:
                Utility.decompose(obj, "3");
                break;
            default:
                obj.jTextArea3.append("No decomposition required");
                break;
        }
    }
    
    private static void updateDependency(Main obj)
    {
        Vector<Vector<ArrayList<String>>> val = new Vector<>();
        outer: for(Vector<ArrayList<String>> dep : obj.dependency)
        {
            for(String leftattr : dep.get(0))
            {
                if(!obj.attribute.contains(leftattr))
                {
                    if(!val.contains(dep))
                    {
                        val.add(dep);
                    }
                    continue outer;
                }
            }
            for(String rightattr : dep.get(1))
            {
                if(!obj.attribute.contains(rightattr))
                {
                    if(!val.contains(dep))
                    {
                        val.add(dep);
                    }
                    continue outer;
                }
            }
        }
        obj.dependency.removeAll(val);
    }
        
    private static ArrayList<String> getDependent(Main obj, ArrayList<String> attr)
    {
        ArrayList<String> dependent = new ArrayList<>();
        dependent.addAll(attr);
        for(Vector<ArrayList<String>> dep : obj.dependency)
        {
            if(attr.containsAll(dep.get(0)) && !dependent.contains(dep.get(1).get(0)))
            {
                dependent.add(dep.get(1).get(0));
            }
        }
        return dependent;
    }
    
    private static ArrayList<String> getClosureSet(Main obj, ArrayList<String> attr)
    {
        ArrayList<String> dependent = new ArrayList<>();
        ArrayList<String> newdep = Utility.getDependent(obj, attr);
        do
        {
            dependent = newdep;
            newdep = Utility.getDependent(obj, dependent);
        } while(!dependent.containsAll(newdep));
        return dependent;
    }
    
    private static void getClosureAll(Main obj)
    {
        obj.closure.clear();
        int attrsize = obj.attribute.size();
        int max = 1 << attrsize;
        for(int i = 1; i < max; i++)
        {
            ArrayList<String> attr = new ArrayList<>();
            for(int j = 0; j < attrsize; j++)
            {
                if(((i >> j) & 1) == 1)
                {
                    attr.add(obj.attribute.get(j));
                }
            }
            ArrayList<String> close = Utility.getClosureSet(obj, attr);
            Vector<ArrayList<String>> cl = new Vector<>();
            cl.add(attr);
            cl.add(close);
            obj.closure.add(cl);
        }
    }
    
    private static void getKeys(Main obj)
    {
        obj.keys.clear();
        outer: for(Vector<ArrayList<String>> close : obj.closure)
        {
            if(close.get(1).containsAll(obj.attribute))
            {
                ArrayList<String> attr = close.get(0);
                int size = attr.size();
                int max = 1 << size;
                for(int i = 1; i < max; i++)
                {
                    ArrayList<String> at = new ArrayList<>();
                    for(int j = 0; j < size; j++)
                    {
                        if(((i >> j) & 1) == 1)
                        {
                            at.add(attr.get(j));
                        }
                    }
                    if(obj.keys.contains(at))
                    {
                        continue outer;
                    }
                }
                obj.keys.add(attr);
            }
        }
    }
    
    private static boolean isSecondForm(Main obj, Vector<ArrayList<String>> dep)
    {
        ArrayList<String> left = dep.get(0);
        ArrayList<String> right = dep.get(1);
        if(!obj.keys.contains(right))
        {
            for(ArrayList<String> key : obj.keys)
            {
                if(key.containsAll(left) && !left.containsAll(key))
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    private static boolean isThirdForm(Main obj, Vector<ArrayList<String>> dep)
    {
        ArrayList<String> left = dep.get(0);
        ArrayList<String> right = dep.get(1);
        if(!obj.keys.contains(left))
        {
            for(ArrayList<String> key : obj.keys)
            {
                if(key.contains(right.get(0)))
                {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    private static boolean isBCNF(Main obj, Vector<ArrayList<String>> dep)
    {
        ArrayList<String> left = dep.get(0);
        return obj.keys.contains(left);
    }
    
    private static void getNormalFormAll(Main obj)
    {
        for(Vector<ArrayList<String>> dep : obj.dependency)
        {
            ArrayList<String> nf = new ArrayList<>();
            if(!Utility.isSecondForm(obj, dep))
            {
                nf.add("1");
            }
            else if(!Utility.isThirdForm(obj, dep))
            {
                nf.add("2");
            }
            else if(!Utility.isBCNF(obj, dep))
            {
                nf.add("3");
            }
            else
            {
                nf.add("4");
            }
            dep.add(2, nf);
        }
    }
    
    private static void decompose(Main obj, String nf)
    {
        boolean flag;
        int i = 1;
        do
        {
            flag = false;
            ArrayList<String> newTable = new ArrayList<>();
            ArrayList<String> key = null;
            for(Vector<ArrayList<String>> dep : obj.dependency)
            {
                if(dep.get(2).get(0).equals(nf))
                {
                    key = dep.get(0);
                    newTable.addAll(dep.get(0));
                    newTable.add(dep.get(1).get(0));
                    obj.attribute.remove(dep.get(1).get(0));
                    flag = true;
                    break;
                }
            }
            if(flag)
            {
                obj.jTextArea3.append("Relation " + (i++) + newTable.toString() + "        Key: " + key.toString() + "\n");
                Utility.updateDependency(obj);
                Utility.getClosureAll(obj);
                Utility.getKeys(obj);
                Utility.getNormalFormAll(obj);
            }
        } while(flag);
        if(!obj.attribute.isEmpty())
        {
            String keys = obj.keys.toString();
            obj.jTextArea3.append("Relation " + (i++) + obj.attribute.toString() + "        Key: " + keys.substring(1, keys.length()-1) + "\n");
        }
    }
}
