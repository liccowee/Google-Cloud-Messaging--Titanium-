/* C++ code produced by gperf version 3.0.3 */
/* Command-line: gperf -L C++ -E -t /Users/activate/Desktop/gcm/build/generated/KrollGeneratedBindings.gperf  */
/* Computed positions: -k'' */

#line 3 "/Users/activate/Desktop/gcm/build/generated/KrollGeneratedBindings.gperf"


#include <string.h>
#include <v8.h>
#include <KrollBindings.h>

#include "com.activate.gcm.C2dmModule.h"


#line 13 "/Users/activate/Desktop/gcm/build/generated/KrollGeneratedBindings.gperf"
struct titanium::bindings::BindEntry;
/* maximum key range = 1, duplicates = 0 */

class GcmBindings
{
private:
  static inline unsigned int hash (const char *str, unsigned int len);
public:
  static struct titanium::bindings::BindEntry *lookupGeneratedInit (const char *str, unsigned int len);
};

inline /*ARGSUSED*/
unsigned int
GcmBindings::hash (register const char *str, register unsigned int len)
{
  return len;
}

struct titanium::bindings::BindEntry *
GcmBindings::lookupGeneratedInit (register const char *str, register unsigned int len)
{
  enum
    {
      TOTAL_KEYWORDS = 1,
      MIN_WORD_LENGTH = 27,
      MAX_WORD_LENGTH = 27,
      MIN_HASH_VALUE = 27,
      MAX_HASH_VALUE = 27
    };

  static struct titanium::bindings::BindEntry wordlist[] =
    {
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
      {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""}, {""},
#line 15 "/Users/activate/Desktop/gcm/build/generated/KrollGeneratedBindings.gperf"
      {"com.activate.gcm.C2dmModule", ::com::activate::gcm::C2dmModule::bindProxy, ::com::activate::gcm::C2dmModule::dispose}
    };

  if (len <= MAX_WORD_LENGTH && len >= MIN_WORD_LENGTH)
    {
      register int key = hash (str, len);

      if (key <= MAX_HASH_VALUE && key >= 0)
        {
          register const char *s = wordlist[key].name;

          if (*str == *s && !strcmp (str + 1, s + 1))
            return &wordlist[key];
        }
    }
  return 0;
}
#line 16 "/Users/activate/Desktop/gcm/build/generated/KrollGeneratedBindings.gperf"

