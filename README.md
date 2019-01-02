# Nested-XML-file-Checker


Write a program that identifies whether or not the contents of a file are a properly-nested XML
file. Your program will also print the tag nesting structure found in the file.


Test cases
Files:
• File name that doesn’t exist
• File with no lines in it
• File with 1 line in it
• File with 2 lines in it
• File with many lines (so a middle line)
Tags:
• Tag name of 1 character
• Tag name of 2 or more characters
• No space between tag name and the opening/closing angle brackets
• White space between the tag name and the opening/closing angle brackets
• Tags on their own lines as the sole content
• Tags amid text in a line (start of line, middle of line, end of line)
• Multiple tags on the same text line
Nesting structure:
• Empty file
• File with no tags in it
• File with bracket tags in it – (nesting depth of 1)
• File with stand-along tags in it
• File with bracket tags nested inside other bracket tags
• File with stand-alone tags nested inside other bracket tags
• Have nesting depth of 2
• Have nesting depth of 5
• Bracketing tags where the closing tag is before the opening tag
Valid nesting:
• Empty file
• File with no tags in it
• File with stand-alone tags only
• File with bracketing tags only, nested correctly, all at nesting depth 1
• File with bracketing tags only, nested incorrectly, all at nesting depth 1
• Match opening/closing tags with different capitalizations
• File with bracketing tags and only stand-alone tags inside the brackets
• File with bracketing tags, nested correctly, all at nesting depth 2 or more
• File with bracketing tags, nested incorrectly, all at nesting depth 2 or more
• Use the same tag to nest inside itself
• File that ends before having all of the closing bracketing tags
