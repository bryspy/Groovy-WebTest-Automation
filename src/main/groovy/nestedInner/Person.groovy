package nestedInner

/**
 * Created by bikonomovski on 7/1/2015.
 */
class Person {
    Name name

    void printIt() {
        String first = this.name.first.toLowerCase()
        String last = this.name.last.toLowerCase()

        first = first.replace(first.charAt(0),first.charAt(0).toUpperCase())
        last = last.replace(last.charAt(0),last.charAt(0).toUpperCase())

        println "${first} ${last}"
    }

    void printItReverse() {
        String first = this.name.first.reverse().toLowerCase()
        String last = this.name.last.reverse().toLowerCase()

        first = first.replace(first.charAt(0),first.charAt(0).toUpperCase())
        last = last.replace(last.charAt(0),last.charAt(0).toUpperCase())

        println "${first} ${last}"
    }
}
