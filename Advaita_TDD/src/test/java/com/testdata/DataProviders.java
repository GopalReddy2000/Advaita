package com.testdata;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	

//	@DataProvider(name = "processNameData")
//	public Object[][] invalidInputForTextfield() {
//	    return new Object[][] {
//	        {"!@#$%^&*"},
//	        {"(*/ω＼*)"},
//	        {"1234456"},
//	        {"过程"},      
//	        {"   "}
//	    };
//	}
	
	
	@DataProvider(name = "processNameData")
	public Object[][] invalidInputForTextfield() {
	    return new Object[][] {
	        // 1️- Empty / Boundary / Space
	        { "" },              // emptyInput → completely empty
	        { "   " },           // whitespaceOnly → only spaces

	        // 2️-Control / Non-printable
	        { "Abhi\tDas" },     // tabCharacter → contains tab
	        { "Abhi\r\nDas" },   // newlineCRLF → contains CRLF characters
	      //  { "test\0name" },    // nullByte → contains null byte

	        // 3️- Unicode / Encoding Edge
	        { "(*/ω＼*)" },      // unicodeEmojiMix → unicode / emoji-like symbols
	        { "éxample" },      // combiningCharacters → accent combining test
	        { "abc\u202Eevil" }, // rightToLeftOverride → RTL override char
	        { "过程" },           // nonLatinChars → Chinese / non-Latin input
	      //  { "😁😁😁😁" },       // emojiOnly → emojis only

	        // 4️- Format / Type Mismatch
	        { "1234456" },       // numericOnly → digits only when text expected
	        { "@@@@@@" },        // symbolOnly → special symbols only
	        { "#$%^&*()" },      // mixedGarbage → random mixed symbols

	        // 5️- Injection Attempts
	        { "' OR '1'='1' --" },                // sqlInjection_basic → simple SQLi
	        { "admin'; DROP TABLE users; --" },   // sqlInjection_drop → SQLi with DROP
	        { "; ls -la" },                       // commandInjection → OS command
	        { "*)(uid=*))(|(uid=*" },             // ldapInjection → LDAP injection
	        { "'] | //user[password/text()='x' or 'x'='x" }, // xpathInjection → XPath logic bypass

	        // 6️- HTML / XSS Injection
	        { "<script>alert(1)</script>" },      // xss_scriptTag → classic XSS
	        { "\"><img src=x onerror=alert(1)>" },// xss_imgTag → attribute injection
	        { "<svg onload=alert(1)>" },          // xss_svgTag → SVG-based XSS
	        { "&lt;script&gt;alert(1)&lt;/script&gt;" }, // xss_encoded → encoded XSS test

	        // 7️- Path / File / Header Injection
	        { "../../etc/passwd" },               // pathTraversal → directory traversal
	        { "..%2F..%2Fetc%2Fpasswd" },         // pathTraversalEncoded → URL-encoded traversal
	        { "Name\r\nSet-Cookie: session=1" },  // headerInjection → CRLF header injection

	        // 8️- CSV / Template Injection
	        { "=cmd|' /C calc'!A0" },             // csvInjection → CSV / Excel formula injection
	        { "{{7*7}}" },                        // templateInjection → template expression
	        { "${7*7}" }                          // templateInjectionAlt → alternate template syntax
	    };
	}
	
	
//	@DataProvider(name = "processNameData")
//	public Object[][] invalidInputForTextfield() {
//	    return new Object[][] {
//	        // 1️⃣ Empty / Boundary / Space
//	        { "emptyInput",             ""                  }, // completely empty
//	        { "whitespaceOnly",         "   "               }, // only spaces
//
//	        // 2️⃣ Control / Non-printable
//	        { "tabCharacter",           "Abhi\tDas"         }, // contains tab
//	        { "newlineCRLF",            "Abhi\r\nDas"       }, // CRLF characters
//	        { "nullByte",               "test\0name"        }, // contains null byte
//
//	        // 3️⃣ Unicode / Encoding Edge
//	        { "unicodeEmojiMix",        "(*/ω＼*)"          }, // unicode / emoji-like characters
//	        { "combiningCharacters",    "éxample"          }, // combining accent form
//	        { "rightToLeftOverride",    "abc\u202Eevil"     }, // right-to-left override char
//	        { "nonLatinChars",          "过程"              }, // Chinese / non-Latin characters
//	        { "emojiOnly",              "😁😁😁😁"           }, // emojis only
//
//	        // 4️⃣ Format / Type Mismatch
//	        { "numericOnly",            "1234456"           }, // numbers only when text expected
//	        { "symbolOnly",             "@@@@@@"            }, // only special chars
//	        { "mixedGarbage",           "#$%^&*()"          }, // mixed special symbols
//
//	        // 5️⃣ Injection Attempts
//	        { "sqlInjection_basic",     "' OR '1'='1' --"   }, // simple SQLi
//	        { "sqlInjection_drop",      "admin'; DROP TABLE users; --" }, // SQLi with DROP
//	        { "commandInjection",       "; ls -la"          }, // OS command injection
//	        { "ldapInjection",          "*)(uid=*))(|(uid=*" }, // LDAP injection
//	        { "xpathInjection",         "'] | //user[password/text()='x' or 'x'='x" }, // XPath logic bypass
//
//	        // 6️⃣ HTML / XSS Injection
//	        { "xss_scriptTag",          "<script>alert(1)</script>" }, // classic XSS
//	        { "xss_imgTag",             "\"><img src=x onerror=alert(1)>" }, // attribute injection
//	        { "xss_svgTag",             "<svg onload=alert(1)>"    }, // SVG XSS
//	        { "xss_encoded",            "&lt;script&gt;alert(1)&lt;/script&gt;" }, // encoded payload
//
//	        // 7️⃣ Path / File / Header Injection
//	        { "pathTraversal",          "../../etc/passwd" }, // directory traversal
//	        { "pathTraversalEncoded",   "..%2F..%2Fetc%2Fpasswd" }, // URL-encoded traversal
//	        { "headerInjection",        "Name\r\nSet-Cookie: session=1" }, // CRLF header injection
//
//	        // 8️⃣ CSV / Template Injection
//	        { "csvInjection",           "=cmd|' /C calc'!A0" }, // CSV / Excel formula injection
//	        { "templateInjection",      "{{7*7}}"           }, // template engine injection
//	        { "templateInjectionAlt",   "${7*7}"            }  // alternate template syntax
//	    };
//	}

	
}
