package com.mycompany.myutils;

import java.text.DecimalFormat;

import org.springframework.stereotype.Component;

/**
 * Service that converts numbers to words.
 */
@Component
public class NumberToWordsService implements Service {

	// inject values from resources for internationalization
	private String negative = "negative";
	private String zero = "zero";
	private String one = "one";
	private String hundred = "hundred";
	private String thousand = "thousand";
	private String million = "million";
	private String billion = "billion";
	private String[] tensNames = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty", " ninety" };
	private String[] numNames = { "", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen" };

	private String convertLessThanOneThousand(int number) {
		String soFar;

		if (number % 100 < 20) {
			soFar = numNames[number % 100];
			number /= 100;
		} else {
			soFar = numNames[number % 10];
			number /= 10;

			soFar = tensNames[number % 10] + soFar;
			number /= 10;
		}
		if (number == 0)
			return soFar;
		return numNames[number] + " " + hundred + soFar;
	}

	public String convert(long number) {
		boolean neg = false;
		// 0 to 999 999 999 999
		if (number == 0) {
			return zero;
		}

		if (number < 0) {
			number = -1 * number;
			neg = true;
		}

		String snumber = Long.toString(number);

		// pad with "0"
		String mask = "000000000000";
		DecimalFormat df = new DecimalFormat(mask);
		snumber = df.format(number);

		// XXXnnnnnnnnn
		int billions = Integer.parseInt(snumber.substring(0, 3));
		// nnnXXXnnnnnn
		int millions = Integer.parseInt(snumber.substring(3, 6));
		// nnnnnnXXXnnn
		int hundredThousands = Integer.parseInt(snumber.substring(6, 9));
		// nnnnnnnnnXXX
		int thousands = Integer.parseInt(snumber.substring(9, 12));

		String tradBillions;
		switch (billions) {
		case 0:
			tradBillions = "";
			break;
		case 1:
			tradBillions = convertLessThanOneThousand(billions) + " " + billion;
			break;
		default:
			tradBillions = convertLessThanOneThousand(billions) + " " + billion;
		}
		String result = tradBillions;

		String tradMillions;
		switch (millions) {
		case 0:
			tradMillions = "";
			break;
		case 1:
			tradMillions = convertLessThanOneThousand(millions) + " " + million;
			break;
		default:
			tradMillions = convertLessThanOneThousand(millions) + " " + million;
		}
		result = result + tradMillions;

		String tradHundredThousands;
		switch (hundredThousands) {
		case 0:
			tradHundredThousands = "";
			break;
		case 1:
			tradHundredThousands = one + " " + thousand;
			break;
		default:
			tradHundredThousands = convertLessThanOneThousand(hundredThousands) + " " + thousand;
		}
		result = result + tradHundredThousands;

		String tradThousand;
		tradThousand = convertLessThanOneThousand(thousands);
		result = result + tradThousand;
		if (neg)
			return negative + " " + result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
		return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
	}

	public String[] getTensNames() {
		return tensNames;
	}

	public void setTensNames(String[] tensNames) {
		this.tensNames = tensNames;
	}

	public String[] getNumNames() {
		return numNames;
	}

	public void setNumNames(String[] numNames) {
		this.numNames = numNames;
	}

	/**
	 * @return the zero
	 */
	public String getZero() {
		return zero;
	}

	/**
	 * @param zero
	 *            the zero to set
	 */
	public void setZero(String zero) {
		this.zero = zero;
	}

	/**
	 * @return the one
	 */
	public String getOne() {
		return one;
	}

	/**
	 * @param one
	 *            the one to set
	 */
	public void setOne(String one) {
		this.one = one;
	}

	/**
	 * @return the hundred
	 */
	public String getHundred() {
		return hundred;
	}

	/**
	 * @param hundred
	 *            the hundred to set
	 */
	public void setHundred(String hundred) {
		this.hundred = hundred;
	}

	/**
	 * @return the thousand
	 */
	public String getThousand() {
		return thousand;
	}

	/**
	 * @param thousand
	 *            the thousand to set
	 */
	public void setThousand(String thousand) {
		this.thousand = thousand;
	}

	/**
	 * @return the million
	 */
	public String getMillion() {
		return million;
	}

	/**
	 * @param million
	 *            the million to set
	 */
	public void setMillion(String million) {
		this.million = million;
	}

	/**
	 * @return the billion
	 */
	public String getBillion() {
		return billion;
	}

	/**
	 * @param billion
	 *            the billion to set
	 */
	public void setBillion(String billion) {
		this.billion = billion;
	}

}
