package com.nari.slsd.gglck.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.nari.slsd.gglck.entity.UserInfo;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinYin
{
	private static HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
	private static Logger LOG = Logger.getLogger(PinYin.class);

	static
	{
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
	}

	/**
	 * 
	 * 
	 * @param toFind
	 *            要查找的，可以空格分隔
	 * @return
	 */
	public static List<String> doSearch(List<String> all, String toFind)
	{

		ArrayList<String> patterns = new ArrayList<String>();

		StringTokenizer st = new StringTokenizer(toFind, " ");
		while(st.hasMoreElements())
		{
			String str = st.nextToken().trim();
			if(!patterns.contains(str))
			{
				patterns.add(str);
			}
		}

		String[] pArray = patterns.toArray(new String[patterns.size()]);

		List<String> resultList = new ArrayList<String>();

		for(String des : all)
		{
			if(matchString(des, pArray))
			{
				resultList.add(des);
			}
		}

		return resultList;
	}

	/**
	 * 模糊查询用户
	 * 
	 * @param toFind
	 *            要查找的，可以空格分隔
	 * @return
	 */
	public static List<String> doSearchUser(List<UserInfo> all, String toFind)
	{

		ArrayList<String> patterns = new ArrayList<String>();

		StringTokenizer st = new StringTokenizer(toFind, " ");
		while(st.hasMoreElements())
		{
			String str = st.nextToken().trim();
			if(!patterns.contains(str))
			{
				patterns.add(str);
			}
		}

		String[] pArray = patterns.toArray(new String[patterns.size()]);

		List<String> list = new ArrayList<String>();

		for(UserInfo user : all)
		{
			if(matchString(user.getRealName(), pArray))
			{
				list.add(user.getUserId());
			}
		}
		// String userIds = "";
		// if(!CommonTool.isObjNullOrEmpty(list)){
		// for(String str : list){
		// userIds += "'" + str + "',";
		// }
		// if(userIds.length()>0)
		// userIds = userIds.substring(0, userIds.length()-1);
		// }
		//
		return list;
	}
	/**
	 * 匹配一组字符
	 * 
	 * @param name
	 * @param patterns
	 * @return
	 */
	private static boolean matchString(String string, String[] patterns)
	{
		for(String pattern : patterns)
		{
			if(!matchString(string, pattern))
			{
				return false;
			}
		}

		return true;
	}

	/**
	 * 匹配一个字符串
	 * 
	 * @param name
	 * @param pattern
	 * @return
	 */
	private static boolean matchString(String string, String toPattern)
	{

		try
		{
			List<String[]> nameList = getPinyins(string);

			int[] ptr = new int[nameList.size()];

			for(int i = 0; i < nameList.size(); i++)
			{
				ptr[i] = 0;
			}

			ArrayList<String> tmp = new ArrayList<String>();
			tmp.add(string);

			for(int add = 0; add < nameList.size(); add++)
			{
				for(int j = 0; j < nameList.get(add).length; j++)
				{
					ptr[add] = j;

					String str = "";

					for(int i = 0; i < nameList.size(); i++)
					{
						str += nameList.get(i)[ptr[i]];
					}

					if(!tmp.contains(str))
					{
						tmp.add(str);
					}
				}
			}

			String pat = "";
			for(int i = 0; i < toPattern.length(); i++)
			{
				char c = toPattern.charAt(i);

				pat += "[" + Character.toUpperCase(c) + Character.toLowerCase(c) + "]" + ".*";
			}

			Pattern pattern = Pattern.compile(pat);

			for(String str : tmp)
			{
				Matcher matcher = pattern.matcher(str);

				if(matcher.find())
				{
					return true;
				}
			}

			return false;

		}
		catch(BadHanyuPinyinOutputFormatCombination e)
		{
			LOG.error(e);
			return false;
		}
	}

	/**
	 * 返回首字母拼音集合和全拼集合 比如鲁济宁货008，返回ljnh008;lujininghuo008
	 * 
	 * @param character
	 * @return
	 */
	public static String getPinyinFull(String character)
	{
		String first = getPinyin(character, true);
		String full = getPinyin(character, false);
		if(first.length() > 0 && full.length() > 0)
		{
			return first + ";" + full;
		}
		return "";
	}

	/**
	 * 返回首字母集合或者全拼集合 比如鲁济宁货008
	 * 
	 * @param character
	 * @param firstLetter
	 *            true:返回ljnh008;false返回lujininghuo008
	 * @return
	 */
	public static String getPinyin(String character, boolean firstLetter)
	{
		List<String> results = new Vector<String>();
		try
		{
			List<String[]> list = getPinyins(character);

			for(String[] pinyins : list)
			{
				List<String> newResults = new Vector<String>();
				for(String pinyin : pinyins)
				{
					String letter = pinyin;
					if(firstLetter && pinyin.length() > 0 && Character.isLetter(pinyin.charAt(0)))
					{
						letter = "" + pinyin.charAt(0);
					}
					if(results.isEmpty())
					{
						newResults.add(letter);
					}
					else
					{
						for(String old : results)
						{
							newResults.add(old + letter);
						}
					}
				}
				results.clear();
				results.addAll(newResults);
				newResults = null;
			}
		}
		catch(BadHanyuPinyinOutputFormatCombination e)
		{
			LOG.error(e);
		}
		String str = "";
		for(String result : results)
		{
			str += result + ";";
		}
		if(str.endsWith(";"))
		{
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

	/**
	 * 获得字符串每个字的完整拼音，单个字的拼音可能有多个发音，因此为数组
	 * 
	 * @return
	 * @throws BadHanyuPinyinOutputFormatCombination
	 */
	private static List<String[]> getPinyins(String character) throws BadHanyuPinyinOutputFormatCombination
	{

		ArrayList<String[]> pinyins = new ArrayList<String[]>();

		for(int i = 0; i < character.length(); i++)
		{
			String[] pys = PinyinHelper.toHanyuPinyinStringArray(character.charAt(i), format);

			if(pys == null)
			{
				pinyins.add(new String[]
				{String.valueOf(character.charAt(i))});
			}
			else
			{
				pinyins.add(pys);
			}
		}

		return pinyins;
	}

	public static void main(String[] args)
	{
		// List<String> all = new ArrayList<String>();
		// all.add("朝辞白帝彩云间");
		// all.add("千里江陵一日还");
		// all.add("两岸猿声啼不住");
		// all.add("轻舟已过万重山");
		//
		// List<String> resultList = null;
		//
		// resultList = doSearch(all, "bd");
		// for(String result : resultList)
		// {
		// System.out.println(result);
		// }
		// System.out.println("----");
		//
		// resultList = doSearch(all, "wzs");
		// for(String result : resultList)
		// {
		// System.out.println(result);
		// }
		// System.out.println("----");
		//
		// resultList = doSearch(all, "过");
		// for(String result : resultList)
		// {
		// System.out.println(result);
		// }
		// System.out.println("----");

		String result = getPinyin("帝云重云都彩降", true);
		System.out.println(result);
	}
}
